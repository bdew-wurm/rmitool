package net.bdew.wurm.rmitool;

import com.wurmonline.server.webinterface.WebInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4) err("Usage: rmitool.jar <addr> <port> <pass> <command> [args...]");
        String addr = args[0];
        int port = safeInt(args[1]);
        String pass = args[2];
        String cmd = args[3];
        String name = "";
        WebInterface iface;
        try {
            iface = setupConnection(addr, port);
            switch (cmd) {
                case "shutdown":
                    if (args.length != 7) err("Usage: shutdown <name> <seconds> <reason>");
                    name = args[4];
                    int seconds = safeInt(args[5]);
                    String reason = args[6];
                    doShutdown(iface, pass, name, seconds, reason);
                    System.err.println("Command sent!");
                    break;
                case "addmoney":
                    if (args.length != 7) err("Usage: addmoney <player_name> <amount> <reason>");
                    name = args[4];
                    long amount = safeLong(args[5]);
                    String detail = args[6];
                    long playerID = doGetPlayerId(iface, pass, name);
                    long currentAmount = doGetMoney(iface, pass, playerID, name);
                    currentAmount += amount;
                    doSetPlayerMoney(iface, pass, playerID, currentAmount, amount, detail);
                    System.err.println("Command sent!");
                    break;
                case "broadcast":
                    if (args.length != 5) err("Usage: broadcast <message>");
                    String message = args[4];
                    doBroadcast(iface, pass, message);
                    System.err.println("Command sent!");
                    break;
                case "playercount":
                    System.out.println(doGetPlayerCount(iface, pass));
                    break;
                case "isrunning":
                    if (doIsRunning(iface, pass))
                        System.err.println("Server is running");
                    else
                        err("Server is online but returned false, this shouldn't happen.");
                    break;
                default:
                    err("Unknown command: " + cmd);
            }
        } catch (RemoteException | NotBoundException e) {
            err("Connection error: " + e.toString());
        }
    }

    // ==== COMMAND HANDLERS ====

    public static void doShutdown(WebInterface iface, String pass, String name, int seconds, String reason) throws RemoteException {
        iface.startShutdown(pass, name, seconds, reason);
    }

    public static long doGetPlayerId(WebInterface iface, String pass, String name) throws RemoteException {
        return iface.getPlayerId(pass, name);
    }

    public static long doGetMoney(WebInterface iface, String pass, long playerId, String playerName) throws RemoteException {
        return iface.getMoney(pass, playerId, playerName);
    }

    public static void doSetPlayerMoney(WebInterface iface, String pass, long playerId, long current, long added, String detail)  throws RemoteException {
        iface.setPlayerMoney(pass, playerId, current, added, detail);
    }

    public static void doBroadcast(WebInterface iface, String pass, String message) throws RemoteException {
        iface.broadcastMessage(pass, message);
    }

    public static boolean doIsRunning(WebInterface iface, String pass) throws RemoteException {
        return iface.isRunning(pass);
    }

    public static int doGetPlayerCount(WebInterface iface, String pass) throws RemoteException {
        return iface.getPlayerCount(pass);
    }

    // ==== MISC ====

    public static int safeInt(String s) {
        try {
            return Integer.parseInt(s, 10);
        } catch (NumberFormatException e) {
            err("Parse error: '" + s + "' is not a valid integer");
            return 0; //unreachable
        }
    }

    public static long safeLong(String s) {
        try {
            return Long.parseLong(s, 10);
        } catch (NumberFormatException e) {
            err("Parse error: '" + s + "' is not a valid long");
            return 0;
        }
    }

    public static void err(String s) {
        System.err.println("Error: " + s);
        System.exit(1);
    }

    public static WebInterface setupConnection(String host, int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host, port);
        return (WebInterface) registry.lookup("wuinterface");
    }
}
