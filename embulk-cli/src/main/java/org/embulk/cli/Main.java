package org.embulk.cli;

public class Main
{
    public static void main(String[] args)
    {
        // $ java -jar jruby-complete.jar classpath:embulk/command/embulk.rb "$@"
        String[] jrubyArgs = new String[args.length + 1];
        jrubyArgs[0] = "classpath:embulk/command/embulk.rb";
        System.arraycopy(args, 0, jrubyArgs, 1, args.length);
        org.jruby.Main.main(jrubyArgs);
    }
}
