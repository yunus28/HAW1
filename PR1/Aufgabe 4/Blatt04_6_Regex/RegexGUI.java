import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 * Ein grafisches Tool zum spielerischen Erlernen von regulaeren Ausdruecken.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2018
 */
class RegexGUI
{
    /*
     * Diese Klasse entspricht nicht den Quelltextkonventionen vno SE1 und sollte nicht als
     * Beispiel fuer eigene Klassen herangezogen werden.
     */
    
    private static final int BREITE = 50;
    private static final int HOEHE = 5;
    private static final Font font = new Font("Monospaced", Font.PLAIN, 16);
    private static final Color SUCCESS =  new Color(200, 250, 210);
    private static final Color ERROR = new Color(241, 165, 170);
    private static final int INITIAL_POS = 4;
    private static final int PADDING = 4;

    private JFrame frame;

    private JTextField regex;

    private JLabel interpretation;
    private JTextArea console;

    private JTextField input;

    private Pattern pattern;
    private Matcher matcher;

    public RegexGUI()
    {
        frame = new JFrame("Regex GUI");
        frame.setLayout(new SpringLayout());

        initializeComponents();
        addListeners();
        startWithExample();
        displayGUI();
    }

    private void initializeComponents()
    {
        initRegex();
        initConsole();
        initInput();
    }

    private void initRegex()
    {
        regex = new JTextField(BREITE);
        insertRow(new JLabel("regex:"), regex);
    }

    private void initConsole()
    {
        interpretation = new JLabel();
        console = new JTextArea(HOEHE, BREITE);
        console.setEditable(false);
        insertRow(interpretation, console);
    }

    private void initInput()
    {
        input = new JTextField(BREITE);
        insertRow(new JLabel("input:"), input);
    }

    private void insertRow(Component left, JTextComponent right)
    {
        right.setFont(font);
        frame.add(left);
        frame.add(right);
    }

    private void addListeners()
    {
        addRegexValidationListener();
        addInputValidationListener();
        regex.addActionListener(new FocusGrabber(input));
        input.addActionListener(new FocusGrabber(regex));
    }

    private void addRegexValidationListener()
    {
        addDocumentListener(regex, new Runnable()
        {
            @Override
            public void run()
            {
                validateRegex();
            }
        });
    }

    private void addInputValidationListener()
    {
        addDocumentListener(input, new Runnable()
        {
            @Override
            public void run()
            {
                validateInput();
            }
        });
    }

    private static void addDocumentListener(JTextComponent component,
            Runnable listener)
    {
        component.getDocument().addDocumentListener(
                new DocumentListenerAdapter(listener));
    }

    private void validateRegex()
    {
        try
        {
            pattern = Pattern.compile(regex.getText());
            String literal = Strings.stringLiteral(regex.getText());
            updateComponents(SUCCESS, "literal:", literal, true);
            validateInput();
        }
        catch (PatternSyntaxException error)
        {
            updateComponents(ERROR, "error:", error.getMessage(), false);
            input.setBackground(Color.WHITE);
        }
    }

    private void updateComponents(Color regexBackground,
            String interpretationText, String consoleText, boolean inputEditable)
    {
        regex.setBackground(regexBackground);
        interpretation.setText(interpretationText);
        console.setText(consoleText);
        input.setEditable(inputEditable);
    }

    private void validateInput()
    {
        matcher = pattern.matcher(input.getText());
        input.setBackground(matcher.matches() ? SUCCESS : ERROR);
    }

    private void startWithExample()
    {
        regex.setText("([a-z]+)@([a-z]+\\.[a-z]+)");
        input.setText("spiderman@web.de");
    }

    private void displayGUI()
    {
        SpringUtilities.makeCompactGrid(frame.getContentPane(), 3, 2,
                INITIAL_POS, INITIAL_POS, PADDING, PADDING);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class FocusGrabber implements ActionListener
{
    private final JTextComponent component;

    public FocusGrabber(JTextComponent component)
    {
        this.component = component;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        component.grabFocus();
        component.selectAll();
    }
}

class DocumentListenerAdapter implements DocumentListener
{
    private final Runnable listener;

    public DocumentListenerAdapter(Runnable listener)
    {
        this.listener = listener;
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        listener.run();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        listener.run();
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        listener.run();
    }
}

class Strings
{
    public static String stringLiteral(String string)
    {
        final int len = string.length();
        // The output is going to be at least 2 characters longer.
        final StringBuilder sb = new StringBuilder(len + 2);
        sb.append('"');
        for (int i = 0; i < len; ++i)
        {
            char c = string.charAt(i);
            String s;
            switch (c)
            {
            case '\b':
                s = "\\b";
                break;

            case '\t':
                s = "\\t";
                break;

            case '\n':
                s = "\\n";
                break;

            case '\f':
                s = "\\f";
                break;

            case '\r':
                s = "\\r";
                break;

            case '"':
                s = "\\\"";
                break;

            case '\\':
                s = "\\\\";
                break;

            default:
                if (c < 32 || c >= 127 && c < 256)
                {
                    s = String.format("\\%03o", (int) c);
                }
                else if (c >= 256)
                {
                    s = String.format("\\u%04x", (int) c);
                }
                else
                {
                    sb.append(c);
                    continue;
                }
            }
            sb.append(s);
        }
        sb.append('"');
        return sb.toString();
    }
}

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/**
 * A 1.4 file that provides utility methods for
 * creating form- or grid-style layouts with SpringLayout.
 * These utilities are used by several programs, such as
 * SpringBox and SpringCompactGrid.
 */
class SpringUtilities {
    /**
     * A debugging utility that prints to stdout the component's
     * minimum, preferred, and maximum sizes.
     */
    public static void printSizes(Component c) {
        System.out.println("minimumSize = " + c.getMinimumSize());
        System.out.println("preferredSize = " + c.getPreferredSize());
        System.out.println("maximumSize = " + c.getMaximumSize());
    }

    /**
     * Aligns the first <code>rows</code> * <code>cols</code>
     * components of <code>parent</code> in
     * a grid. Each component is as big as the maximum
     * preferred width and height of the components.
     * The parent is made just big enough to fit them all.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @param initialX x location to start the grid at
     * @param initialY y location to start the grid at
     * @param xPad x padding between cells
     * @param yPad y padding between cells
     */
    public static void makeGrid(Container parent,
                                int rows, int cols,
                                int initialX, int initialY,
                                int xPad, int yPad) {
        SpringLayout layout;
        try {
            layout = (SpringLayout)parent.getLayout();
        } catch (ClassCastException exc) {
            System.err.println("The first argument to makeGrid must use SpringLayout.");
            return;
        }

        Spring xPadSpring = Spring.constant(xPad);
        Spring yPadSpring = Spring.constant(yPad);
        Spring initialXSpring = Spring.constant(initialX);
        Spring initialYSpring = Spring.constant(initialY);
        int max = rows * cols;

        //Calculate Springs that are the max of the width/height so that all
        //cells have the same size.
        Spring maxWidthSpring = layout.getConstraints(parent.getComponent(0)).
                                    getWidth();
        Spring maxHeightSpring = layout.getConstraints(parent.getComponent(0)).
                                    getWidth();
        for (int i = 1; i < max; i++) {
            SpringLayout.Constraints cons = layout.getConstraints(
                                            parent.getComponent(i));

            maxWidthSpring = Spring.max(maxWidthSpring, cons.getWidth());
            maxHeightSpring = Spring.max(maxHeightSpring, cons.getHeight());
        }

        //Apply the new width/height Spring. This forces all the
        //components to have the same size.
        for (int i = 0; i < max; i++) {
            SpringLayout.Constraints cons = layout.getConstraints(
                                            parent.getComponent(i));

            cons.setWidth(maxWidthSpring);
            cons.setHeight(maxHeightSpring);
        }

        //Then adjust the x/y constraints of all the cells so that they
        //are aligned in a grid.
        SpringLayout.Constraints lastCons = null;
        SpringLayout.Constraints lastRowCons = null;
        for (int i = 0; i < max; i++) {
            SpringLayout.Constraints cons = layout.getConstraints(
                                                 parent.getComponent(i));
            if (i % cols == 0) { //start of new row
                lastRowCons = lastCons;
                cons.setX(initialXSpring);
            } else { //x position depends on previous component
                cons.setX(Spring.sum(lastCons.getConstraint(SpringLayout.EAST),
                                     xPadSpring));
            }

            if (i / cols == 0) { //first row
                cons.setY(initialYSpring);
            } else { //y position depends on previous row
                cons.setY(Spring.sum(lastRowCons.getConstraint(SpringLayout.SOUTH),
                                     yPadSpring));
            }
            lastCons = cons;
        }

        //Set the parent's size.
        SpringLayout.Constraints pCons = layout.getConstraints(parent);
        pCons.setConstraint(SpringLayout.SOUTH,
                            Spring.sum(
                                Spring.constant(yPad),
                                lastCons.getConstraint(SpringLayout.SOUTH)));
        pCons.setConstraint(SpringLayout.EAST,
                            Spring.sum(
                                Spring.constant(xPad),
                                lastCons.getConstraint(SpringLayout.EAST)));
    }

    /* Used by makeCompactGrid. */
    private static SpringLayout.Constraints getConstraintsForCell(
                                                int row, int col,
                                                Container parent,
                                                int cols) {
        SpringLayout layout = (SpringLayout) parent.getLayout();
        Component c = parent.getComponent(row * cols + col);
        return layout.getConstraints(c);
    }

    /**
     * Aligns the first <code>rows</code> * <code>cols</code>
     * components of <code>parent</code> in
     * a grid. Each component in a column is as wide as the maximum
     * preferred width of the components in that column;
     * height is similarly determined for each row.
     * The parent is made just big enough to fit them all.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @param initialX x location to start the grid at
     * @param initialY y location to start the grid at
     * @param xPad x padding between cells
     * @param yPad y padding between cells
     */
    public static void makeCompactGrid(Container parent,
                                       int rows, int cols,
                                       int initialX, int initialY,
                                       int xPad, int yPad) {
        SpringLayout layout;
        try {
            layout = (SpringLayout)parent.getLayout();
        } catch (ClassCastException exc) {
            System.err.println("The first argument to makeCompactGrid must use SpringLayout.");
            return;
        }

        //Align all cells in each column and make them the same width.
        Spring x = Spring.constant(initialX);
        for (int c = 0; c < cols; c++) {
            Spring width = Spring.constant(0);
            for (int r = 0; r < rows; r++) {
                width = Spring.max(width,
                                   getConstraintsForCell(r, c, parent, cols).
                                       getWidth());
            }
            for (int r = 0; r < rows; r++) {
                SpringLayout.Constraints constraints =
                        getConstraintsForCell(r, c, parent, cols);
                constraints.setX(x);
                constraints.setWidth(width);
            }
            x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
        }

        //Align all cells in each row and make them the same height.
        Spring y = Spring.constant(initialY);
        for (int r = 0; r < rows; r++) {
            Spring height = Spring.constant(0);
            for (int c = 0; c < cols; c++) {
                height = Spring.max(height,
                                    getConstraintsForCell(r, c, parent, cols).
                                        getHeight());
            }
            for (int c = 0; c < cols; c++) {
                SpringLayout.Constraints constraints =
                        getConstraintsForCell(r, c, parent, cols);
                constraints.setY(y);
                constraints.setHeight(height);
            }
            y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
        }

        //Set the parent's size.
        SpringLayout.Constraints pCons = layout.getConstraints(parent);
        pCons.setConstraint(SpringLayout.SOUTH, y);
        pCons.setConstraint(SpringLayout.EAST, x);
    }
}
