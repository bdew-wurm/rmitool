package com.wurmonline.server.webinterface;

import com.wurmonline.server.players.BannedIp;
import com.wurmonline.shared.exceptions.WurmServerException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface WebInterface extends Remote {
    public static final int DEFAULT_RMI_PORT = 7220;
    public static final int DEFAULT_REGISTRATION_PORT = 7221;

    int getPower(final String p0, final long p1) throws RemoteException;

    boolean isRunning(final String p0) throws RemoteException;

    int getPlayerCount(final String p0) throws RemoteException;

    int getPremiumPlayerCount(final String p0) throws RemoteException;

    String getTestMessage(final String p0) throws RemoteException;

    void broadcastMessage(final String p0, final String p1) throws RemoteException;

    long getAccountStatusForPlayer(final String p0, final String p1) throws RemoteException;

    long chargeMoney(final String p0, final String p1, final long p2) throws RemoteException;

    String getServerStatus(final String p0) throws RemoteException;

    Map<String, Integer> getBattleRanks(final String p0, final int p1) throws RemoteException;

    Map<String, Long> getFriends(final String p0, final long p1) throws RemoteException;

    Map<String, String> getInventory(final String p0, final long p1) throws RemoteException;

    Map<Long, Long> getBodyItems(final String p0, final long p1) throws RemoteException;

    Map<String, Float> getSkills(final String p0, final long p1) throws RemoteException;

    Map<String, ?> getPlayerSummary(final String p0, final long p1) throws RemoteException;

    long getLocalCreationTime(final String p0) throws RemoteException;

    String ban(final String p0, final String p1, final String p2, final int p3) throws RemoteException;

    String pardonban(final String p0, final String p1) throws RemoteException;

    String addBannedIp(final String p0, final String p1, final String p2, final int p3) throws RemoteException;

    BannedIp[] getPlayersBanned(final String p0) throws RemoteException;

    BannedIp[] getIpsBanned(final String p0) throws RemoteException;

    String removeBannedIp(final String p0, final String p1) throws RemoteException;

    Map<Integer, String> getKingdoms(final String p0) throws RemoteException;

    Map<Long, String> getPlayersForKingdom(final String p0, final int p1) throws RemoteException;

    long getPlayerId(final String p0, final String p1) throws RemoteException;

    Map<String, ?> createPlayer(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final byte p6, final byte p7, final long p8, final byte p9) throws RemoteException;

    Map<String, String> createPlayerPhaseOne(final String p0, final String p1, final String p2) throws RemoteException;

    Map<String, ?> createPlayerPhaseTwo(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final byte p6, final byte p7, final long p8, final byte p9, final String p10) throws RemoteException;

    Map<String, ?> createPlayerPhaseTwo(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final byte p6, final byte p7, final long p8, final byte p9, final String p10, final int p11) throws RemoteException;

    Map<String, ?> createPlayerPhaseTwo(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final byte p6, final byte p7, final long p8, final byte p9, final String p10, final int p11, final boolean p12) throws RemoteException;

    byte[] createAndReturnPlayer(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final byte p6, final byte p7, final long p8, final byte p9, final boolean p10, final boolean p11, final boolean p12) throws RemoteException;

    Map<String, String> addMoneyToBank(final String p0, final String p1, final long p2, final String p3) throws RemoteException;

    long getMoney(final String p0, final long p1, final String p2) throws RemoteException;

    Map<String, String> reversePayment(final String p0, final long p1, final int p2, final int p3, final String p4, final String p5, final String p6) throws RemoteException;

    Map<String, String> addMoneyToBank(final String p0, final String p1, final long p2, final String p3, final boolean p4) throws RemoteException;

    Map<String, String> addMoneyToBank(final String p0, final String p1, final long p2, final long p3, final String p4, final boolean p5) throws RemoteException;

    Map<String, String> addPlayingTime(final String p0, final String p1, final int p2, final int p3, final String p4, final boolean p5) throws RemoteException;

    Map<String, String> addPlayingTime(final String p0, final String p1, final int p2, final int p3, final String p4) throws RemoteException;

    Map<Integer, String> getDeeds(final String p0) throws RemoteException;

    Map<String, ?> getDeedSummary(final String p0, final int p1) throws RemoteException;

    Map<String, Long> getPlayersForDeed(final String p0, final int p1) throws RemoteException;

    Map<String, Integer> getAlliesForDeed(final String p0, final int p1) throws RemoteException;

    String[] getHistoryForDeed(final String p0, final int p1, final int p2) throws RemoteException;

    String[] getAreaHistory(final String p0, final int p1) throws RemoteException;

    Map<String, ?> getItemSummary(final String p0, final long p1) throws RemoteException;

    Map<String, String> getPlayerIPAddresses(final String p0) throws RemoteException;

    Map<String, String> getNameBans(final String p0) throws RemoteException;

    Map<String, String> getIPBans(final String p0) throws RemoteException;

    Map<String, String> getWarnings(final String p0) throws RemoteException;

    String getWurmTime(final String p0) throws RemoteException;

    String getUptime(final String p0) throws RemoteException;

    String getNews(final String p0) throws RemoteException;

    String getGameInfo(final String p0) throws RemoteException;

    Map<String, String> getKingdomInfluence(final String p0) throws RemoteException;

    Map<String, ?> getMerchantSummary(final String p0, final long p1) throws RemoteException;

    Map<String, ?> getBankAccount(final String p0, final long p1) throws RemoteException;

    Map<String, ?> authenticateUser(final String p0, final String p1, final String p2, final String p3, final Map p4) throws RemoteException;

    Map<String, ?> authenticateUser(final String p0, final String p1, final String p2, final String p3) throws RemoteException;

    Map<String, String> changePassword(final String p0, final String p1, final String p2, final String p3) throws RemoteException;

    Map<String, String> changePassword(final String p0, final String p1, final String p2, final String p3, final String p4) throws RemoteException;

    boolean changePassword(final String p0, final long p1, final String p2) throws RemoteException;

    Map<String, String> changeEmail(final String p0, final String p1, final String p2, final String p3) throws RemoteException;

    String getChallengePhrase(final String p0, final String p1) throws RemoteException;

    String[] getPlayerNamesForEmail(final String p0, final String p1) throws RemoteException;

    String getEmailAddress(final String p0, final String p1) throws RemoteException;

    Map<String, String> requestPasswordReset(final String p0, final String p1, final String p2) throws RemoteException;

    Map<Integer, String> getAllServers(final String p0) throws RemoteException;

    Map<Integer, String> getAllServerInternalAddresses(final String p0) throws RemoteException;

    boolean sendMail(final String p0, final String p1, final String p2, final String p3, final String p4) throws RemoteException;

    Map<String, String> getPendingAccounts(final String p0) throws RemoteException;

    void shutDown(final String p0, final String p1, final String p2, final String p3, final int p4) throws RemoteException;

    Map<String, Byte> getReferrers(final String p0, final long p1) throws RemoteException;

    String addReferrer(final String p0, final String p1, final long p2) throws RemoteException;

    String acceptReferrer(final String p0, final long p1, final String p2, final boolean p3) throws RemoteException;

    Map<String, Double> getSkillStats(final String p0, final int p1) throws RemoteException;

    Map<Integer, String> getSkills(final String p0) throws RemoteException;

    Map<String, ?> getStructureSummary(final String p0, final long p1) throws RemoteException;

    long getStructureIdFromWrit(final String p0, final long p1) throws RemoteException;

    Map<String, ?> getTileSummary(final String p0, final int p1, final int p2, final boolean p3) throws RemoteException;

    String getReimbursementInfo(final String p0, final String p1) throws RemoteException;

    boolean withDraw(final String p0, final String p1, final String p2, final String p3, final int p4, final int p5, final boolean p6, final int p7) throws RemoteException;

    boolean transferPlayer(final String p0, final String p1, final int p2, final int p3, final boolean p4, final int p5, final byte[] p6) throws RemoteException;

    boolean setCurrentServer(final String p0, final String p1, final int p2) throws RemoteException;

    boolean addDraggedItem(final String p0, final long p1, final byte[] p2, final long p3, final int p4, final int p5) throws RemoteException;

    String rename(final String p0, final String p1, final String p2, final String p3, final int p4) throws RemoteException;

    String changePassword(final String p0, final String p1, final String p2, final String p3, final int p4) throws RemoteException;

    String changeEmail(final String p0, final String p1, final String p2, final String p3, final String p4, final int p5, final String p6, final String p7) throws RemoteException;

    String addReimb(final String p0, final String p1, final String p2, final int p3, final int p4, final int p5, final boolean p6) throws RemoteException;

    long[] getCurrentServerAndWurmid(final String p0, final String p1, final long p2) throws RemoteException;

    Map<Long, byte[]> getPlayerStates(final String p0, final long[] p1) throws RemoteException, WurmServerException;

    void manageFeature(final String p0, final int p1, final int p2, final boolean p3, final boolean p4, final boolean p5) throws RemoteException;

    void startShutdown(final String p0, final String p1, final int p2, final String p3) throws RemoteException;

    String sendMail(final String p0, final byte[] p1, final byte[] p2, final long p3, final long p4, final int p5) throws RemoteException;

    String setPlayerPremiumTime(final String p0, final long p1, final long p2, final int p3, final int p4, final String p5) throws RemoteException;

    String setPlayerMoney(final String p0, final long p1, final long p2, final long p3, final String p4) throws RemoteException;

    Map<String, String> doesPlayerExist(final String p0, final String p1) throws RemoteException;

    void setWeather(final String p0, final float p1, final float p2, final float p3) throws RemoteException;

    String sendVehicle(final String p0, final byte[] p1, final byte[] p2, final long p3, final long p4, final int p5, final int p6, final int p7, final int p8, final float p9) throws RemoteException;

    void requestDemigod(final String p0, final byte p1, final String p2) throws RemoteException;

    String ascend(final String p0, final int p1, final String p2, final long p3, final byte p4, final byte p5, final byte p6, final float p7, final float p8) throws RemoteException;

    boolean requestDeityMove(final String p0, final int p1, final int p2, final String p3) throws RemoteException;

    void setKingdomInfo(final String p0, final int p1, final byte p2, final byte p3, final String p4, final String p5, final String p6, final String p7, final String p8, final String p9, final boolean p10) throws RemoteException;

    boolean kingdomExists(final String p0, final int p1, final byte p2, final boolean p3) throws RemoteException;

    void genericWebCommand(final String p0, final short p1, final long p2, final byte[] p3) throws RemoteException;

    int[] getPremTimeSilvers(final String p0, final long p1) throws RemoteException;

    void awardPlayer(final String p0, final long p1, final String p2, final int p3, final int p4) throws RemoteException;

    boolean isFeatureEnabled(final String p0, final int p1) throws RemoteException;
}
