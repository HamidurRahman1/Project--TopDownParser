package p2m;

public abstract class Parser extends LexAnalyzer
{
    public static boolean errorFound = false;

    public static void main(String[] argv) throws NullPointerException
    {
        // argv[0]: input file containing a fun def list
        // argv[1]: output file displaying the parse tree

        setIO("/Users/hamidurrahman/Downloads/GitHub/Project--TopDownParser/src/inputs/test.txt",
                "/Users/hamidurrahman/Downloads/GitHub/Project--TopDownParser/src/outputs/out1.txt");

        setLex();

        getToken();

        // build a parse tree
        FunDefList funDefList = getFunDefList();
        getToken();
        System.out.println("list - "+t);

        if (!t.isEmpty())
        {
            errorMsg(5);
        }
        else if(!errorFound)
        {
            // print the parse tree in linearly indented form in argv[1] file
            funDefList.printParseTree("");
        }

        closeIO();
    }

    public static FunDefList getFunDefList()
    {
        FunDef funDef = getFunDef();
        getToken();
        System.out.println("fundeflist - "+t);

        return new FunDefList(funDef, null);
    }

    public static FunDef getFunDef()
    {
        Header header = getHeader();
        getToken();
        System.out.println("fundef - "+t);

        return new FunDef(header, null);
    }

    public static Header getHeader()
    {
        FunName funName = getFunName();
        System.out.println("header - "+funName.id);
        return null;
    }

    public static FunName getFunName()
    {
        if(!t.isEmpty())
            return new FunName(t);
        return null;
    }

    public static void errorMsg(int messageKey)
    {
        errorFound = true;

        display(t + " : Syntax Error, unexpected symbol where");

        switch( messageKey )
        {
            case 1:	displayln(" arith op or ) expected"); return;
            case 2: displayln(" id, int, float, or ( expected"); return;
            case 3:	displayln(" = expected"); return;
            case 4:	displayln(" ; expected"); return;
            case 5:	displayln(" id expected"); return;
        }
    }
}
