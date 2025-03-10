package org.phenopackets.phenopackettools;

import org.phenopackets.phenopackettools.command.ValidateCommand;
import org.phenopackets.phenopackettools.command.ConvertCommand;
import org.phenopackets.phenopackettools.command.ExamplesCommand;
import picocli.AutoComplete;
import picocli.CommandLine;

import java.util.Locale;

import static picocli.CommandLine.Help.Ansi.Style.*;

@CommandLine.Command(name = "phenopacket-tools",
        header = Main.HEADER,
        version = Main.VERSION,
        mixinStandardHelpOptions = true,
        subcommands = {
                // see https://picocli.info/autocomplete.html
                AutoComplete.GenerateCompletion.class,
                ConvertCommand.class,
                ValidateCommand.class,
                ExamplesCommand.class,
        },
        usageHelpWidth = Main.USAGE_WIDTH,
        footer = Main.FOOTER)
public class Main {

    public static final String HEADER = "phenopacket-tools\nAn application for creating, converting and validating GA4GH phenopackets.\n";
    public static final String VERSION = "phenopacket-tools v0.4.6";

    // Maximum number of characters in line of the usage message.
    public static final int USAGE_WIDTH = 120;

    private static final CommandLine.Help.ColorScheme COLOR_SCHEME = new CommandLine.Help.ColorScheme.Builder()
            .commands(bold, fg_blue, underline)
            .options(fg_yellow)
            .parameters(fg_yellow)
            .optionParams(italic)
            .build();

    public static final String FOOTER = "\nSee the full documentation at https://phenopacket-tools.readthedocs.io\n";

    private Main() {
        // private no-op
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //noinspection InstantiationOfUtilityClass
        CommandLine cline = new CommandLine(new Main())
                .setColorScheme(COLOR_SCHEME);
        cline.getSubcommands().get("generate-completion").getCommandSpec().usageMessage().hidden(true);
        System.exit(cline.execute(args));
    }
}