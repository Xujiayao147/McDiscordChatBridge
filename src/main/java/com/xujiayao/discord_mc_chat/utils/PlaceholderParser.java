package com.xujiayao.discord_mc_chat.utils;

import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.node.TextNode;
import eu.pb4.placeholders.api.node.parent.ClickActionNode;
import eu.pb4.placeholders.api.node.parent.FormattingNode;
import eu.pb4.placeholders.api.parsers.MarkdownLiteParserV1;
import eu.pb4.placeholders.api.parsers.NodeParser;
import eu.pb4.placeholders.api.parsers.ParserBuilder;
import eu.pb4.placeholders.api.parsers.TagLikeParser;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
//#if MC < 11900
//$$ import net.minecraft.network.chat.TextComponent;
//#endif

import java.util.Map;

import static com.xujiayao.discord_mc_chat.Main.SERVER;

/**
 * @author Xujiayao
 */
public class PlaceholderParser {

	private static final NodeParser PARSER = ParserBuilder.of()
			.globalPlaceholders()
			.quickText()
			.simplifiedTextFormat()
			.markdown(MarkdownLiteParserV1::defaultSpoilerFormatting,
					MarkdownLiteParserV1::defaultQuoteFormatting,
					PlaceholderParser::customUrlFormatting,
					MarkdownLiteParserV1.MarkdownFormat.values())
			.build();

	private static TextNode customUrlFormatting(TextNode[] textNodes, TextNode url) {
		// TODO Toggle: Yellow vs Blue
		// TODO Hover "Open URL"
		return new ClickActionNode(TextNode.array(new FormattingNode(textNodes, ChatFormatting.YELLOW, ChatFormatting.UNDERLINE)), ClickEvent.Action.OPEN_URL, url);
	}

	public static Component parseOtherMessage(String server, Component message) {
		Map<String, Component> placeholders = Map.of(
				//#if MC >= 11900
				"server", Component.literal(server),
				"message", message
				//#else
				//$$ "server", new TextComponent(server),
				//$$ "message", message
				//#endif
		);

		NodeParser parser = ParserBuilder.of()
				.add(PARSER)
				.customTags(TagLikeParser.PLACEHOLDER_ALTERNATIVE, TagLikeParser.Provider.placeholderText(placeholders::get))
				.build();

		return parser.parseText(TextNode.of(Translations.translateMessage("message.otherMessage")), PlaceholderContext.of(SERVER).asParserContext());
	}

	public static Component parseCommandNotice(String name, String roleName, String roleColor, String command) {
		Map<String, Component> placeholders = Map.of(
				//#if MC >= 11900
				"name", Component.literal(name),
				"roleName", Component.literal(roleName),
				"roleColor", Component.literal(roleColor),
				"command", Component.literal(command)
				//#else
				//$$ "name", new TextComponent(name),
				//$$ "roleName", new TextComponent(roleName),
				//$$ "roleColor", new TextComponent(roleColor),
				//$$ "command", new TextComponent(command)
				//#endif
		);

		NodeParser parser = ParserBuilder.of()
				.add(PARSER)
				.customTags(TagLikeParser.PLACEHOLDER_ALTERNATIVE, TagLikeParser.Provider.placeholderText(placeholders::get))
				.build();

		return parser.parseText(TextNode.of(Translations.translateMessage("message.commandNotice")), PlaceholderContext.of(SERVER).asParserContext());
	}

	public static Component parseResponseMessage(String server, String name, String roleName, String message) {
		Map<String, Component> placeholders = Map.of(
				//#if MC >= 11900
				"server", Component.literal(server),
				"name", Component.literal(name),
				"roleName", Component.literal(roleName),
				"message", Component.literal(message)
				//#else
				//$$ "server", new TextComponent(server),
				//$$ "name", new TextComponent(name),
				//$$ "roleName", new TextComponent(roleName),
				//$$ "message", new TextComponent(message)
				//#endif
		);

		NodeParser parser = ParserBuilder.of()
				.add(PARSER)
				.customTags(TagLikeParser.PLACEHOLDER_ALTERNATIVE, TagLikeParser.Provider.placeholderText(placeholders::get))
				.build();

		return parser.parseText(TextNode.of(Translations.translateMessage("message.responseMessage")), PlaceholderContext.of(SERVER).asParserContext());
	}

	public static Component parseChatMessage(String server, String name, String roleName, String message) {
		Map<String, Component> placeholders = Map.of(
				//#if MC >= 11900
				"server", Component.literal(server),
				"name", Component.literal(name),
				"roleName", Component.literal(roleName),
				"message", Component.literal(message)
				//#else
				//$$ "server", new TextComponent(server),
				//$$ "name", new TextComponent(name),
				//$$ "roleName", new TextComponent(roleName),
				//$$ "message", new TextComponent(message)
				//#endif
		);

		NodeParser parser = ParserBuilder.of()
				.add(PARSER)
				.customTags(TagLikeParser.PLACEHOLDER_ALTERNATIVE, TagLikeParser.Provider.placeholderText(placeholders::get))
				.build();

		return parser.parseText(TextNode.of(Translations.translateMessage("message.chatMessage")), PlaceholderContext.of(SERVER).asParserContext());
	}
}
