package p2m;

public class ExpList extends BaseExpList
{
    public Exp exp;
    public ExpList expList;

    public ExpList(Exp exp)
    {
        this.exp = exp;
    }

    public ExpList(Exp exp, ExpList expList)
    {
        this.exp = exp;
        this.expList = expList;
    }

    @Override
    public void printParseTree(String indent)
    {

    }
}
