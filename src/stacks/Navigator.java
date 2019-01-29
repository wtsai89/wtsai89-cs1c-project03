package stacks;

public class Navigator {

    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    public Navigator()
    {
        currentLink = null;
        backLinks = new StackList<String>("Back Links");
        forwardLinks = new StackList<String>("Forward Links");
    }

    public void setCurrentLink(String link)
    {
        if(currentLink != null)
            backLinks.push(currentLink);
        forwardLinks.clear();
        currentLink = link;
    }

    public void goBack()
    {

        if(backLinks.size() == 0)
            System.out.println("WARNING! No back links left.");
        else {
            forwardLinks.push(currentLink);
            currentLink = backLinks.pop();
        }
    }

    public void goForward()
    {
        if(forwardLinks.size() == 0)
            System.out.println("WARNING! No forward links left.");
        else {
            backLinks.push(currentLink);
            currentLink = forwardLinks.pop();
        }
    }

    public String getCurrentLink(){ return currentLink; }

    public StackList<String> getBackLinks() { return backLinks; }

    public StackList<String> getForwardLinks() { return forwardLinks; }
}
