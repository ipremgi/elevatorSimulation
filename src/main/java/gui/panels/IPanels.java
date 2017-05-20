package gui.panels;

/**
 * Created by IPREMGI on 20/05/2017.
 * Interface class that each Panel will implement
 */
public interface IPanels {

    /**
     * Instantiate each component in the class
     */
    void instantiateComponents();

    /**
     * Add the components to the Panel in the correct order
     */
    void addComponents();
}

