package top.xujiayao.mcdiscordchat.objects;

/**
 * @author Xujiayao
 */
public record Texts(String serverStarted,
                    String serverStopped,
                    String joinServer,
                    String leftServer,
                    String deathMessage,
                    String advancementTask,
                    String advancementChallenge,
                    String advancementGoal,
                    String blueColoredText,
                    String roleColoredText,
                    String colorlessText,
                    boolean removeVanillaFormattingFromDiscord,
                    boolean removeLineBreakFromDiscord) {
}
