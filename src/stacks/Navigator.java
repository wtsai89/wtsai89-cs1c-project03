package stacks;

/**
 * Provides the navigation feature of class BrowserNavigation.
 */
public class Navigator {

    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    /**
     * Default constructor
     */
    public Navigator()
    {
        currentLink = null;
        backLinks = new StackList<String>("Back Links");
        forwardLinks = new StackList<String>("Forward Links");
    }

    /**
     * Takes an object of type String​ for the current requested link and updates the backLinks and forwardLinks stacks.
     * @param link
     */
    public void setCurrentLink(String link)
    {
        if(currentLink != null)
            backLinks.push(currentLink);
        forwardLinks.clear();
        currentLink = link;
    }

    /**
     * Updates the currentLink to the link at the top of the backLinks stack
     */
    public void goBack()
    {
        if(backLinks.size() == 0)
            System.out.println("WARNING! No back links left.");
        else {
            forwardLinks.push(currentLink);
            currentLink = backLinks.pop();
        }
    }

    /**
     * Updates the currentLink to the link at the top of the forwardLinks stack
     */
    public void goForward()
    {
        if(forwardLinks.size() == 0)
            System.out.println("WARNING! No forward links left.");
        else {
            backLinks.push(currentLink);
            currentLink = forwardLinks.pop();
        }
    }

    /**
     * accessor method
     * @return
     */
    public String getCurrentLink(){ return currentLink; }

    /**
     * accessor method
     * @return
     */
    public StackList<String> getBackLinks() { return backLinks; }

    /**
     * accessor method
     * @return
     */
    public StackList<String> getForwardLinks() { return forwardLinks; }
}
