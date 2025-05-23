/*
 * Copyright 2019 FormDev Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.formdev.flatlaf;

import java.awt.Color;
import java.awt.IllegalComponentStateException;
import java.awt.Window;
import java.util.Objects;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

/**
 * Defines/documents own client properties used in FlatLaf.
 *
 * @author Karl Tauber
 */
public interface FlatClientProperties
{
	//---- JButton ------------------------------------------------------------

	/**
	 * Specifies type of button.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #BUTTON_TYPE_SQUARE},
	 *     {@link #BUTTON_TYPE_ROUND_RECT},
	 *     {@link #BUTTON_TYPE_TAB},
	 *     {@link #BUTTON_TYPE_HELP},
	 *     {@link #BUTTON_TYPE_TOOLBAR_BUTTON} or
	 *     {@link #BUTTON_TYPE_BORDERLESS}
	 */
	String BUTTON_TYPE = "JButton.buttonType";

	/**
	 * Paint the button with square edges.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}
	 *
	 * @see #BUTTON_TYPE
	 */
	String BUTTON_TYPE_SQUARE = "square";

	/**
	 * Paint the button with round edges.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}
	 *
	 * @see #BUTTON_TYPE
	 */
	String BUTTON_TYPE_ROUND_RECT = "roundRect";

	/**
	 * Paint the toggle button in tab style.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JToggleButton}
	 *
	 * @see #BUTTON_TYPE
	 */
	String BUTTON_TYPE_TAB = "tab";

	/**
	 * Paint a help button (circle with question mark).
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton}
	 *
	 * @see #BUTTON_TYPE
	 */
	String BUTTON_TYPE_HELP = "help";

	/**
	 * Paint the button in toolbar style.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}
	 *
	 * @see #BUTTON_TYPE
	 */
	String BUTTON_TYPE_TOOLBAR_BUTTON = "toolBarButton";

	/**
	 * Paint the button without a border in the unfocused state.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}
	 *
	 * @see #BUTTON_TYPE
	 * @since 1.2
	 */
	String BUTTON_TYPE_BORDERLESS = "borderless";

	/**
	 * Specifies whether the button preferred size will be made square (quadratically).
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String SQUARE_SIZE = "JButton.squareSize";


	//---- JCheckBox ----------------------------------------------------------

	/**
	 * Specifies selected state of a checkbox.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JCheckBox}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong> {@link #SELECTED_STATE_INDETERMINATE}
	 */
	String SELECTED_STATE = "JButton.selectedState";

	/**
	 * Paint an indeterminate state on a checkbox.
	 *
	 * @see #SELECTED_STATE
	 */
	String SELECTED_STATE_INDETERMINATE = "indeterminate";


	//---- JComponent ---------------------------------------------------------

	/**
	 * Specifies the style of a component as String in CSS syntax ("key1: value1; key2: value2; ...")
	 * or as {@link java.util.Map}&lt;String, Object&gt; with binary values.
	 * <p>
	 * The keys are the same as used in UI defaults, but without component type prefix.
	 * E.g. for UI default {@code Slider.thumbSize} use key {@code thumbSize}.
	 * <p>
	 * The syntax of the CSS values is the same as used in FlatLaf properties files
	 * (<a href="https://www.formdev.com/flatlaf/properties-files/">https://www.formdev.com/flatlaf/properties-files/</a>),
	 * but some features are not supported (e.g. variables).
	 * When using a map, the values are not parsed from a string. They must be binary.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.String} or {@link java.util.Map}&lt;String, Object&gt;<br>
	 *
	 * @since 2
	 */
	String STYLE = "FlatLaf.style";

	/**
	 * Specifies the style class(es) of a component as String (single class or multiple classes separated by space characters)
	 * or as {@code String[]} or {@link java.util.List}&lt;String&gt; (multiple classes).
	 * <p>
	 * The style rules must be defined in UI defaults either as strings (in CSS syntax)
	 * or as {@link java.util.Map}&lt;String, Object&gt; (with binary values).
	 * The key must be in syntax: {@code [style]type.styleClass}, where the type is optional.
	 * E.g. in FlatLaf properties file:
	 * <pre>{@code
	 * [style]Button.primary = borderColor: #08f; background: #08f; foreground: #fff
	 * [style].secondary = borderColor: #0f8; background: #0f8
	 * }</pre>
	 * or in Java code:
	 * <pre>{@code
	 * UIManager.put( "[style]Button.primary", "borderColor: #08f; background: #08f; foreground: #fff" );
	 * UIManager.put( "[style].secondary", "borderColor: #0f8; background: #0f8" );
	 * }</pre>
	 * The rule "Button.primary" can be applied to buttons only.
	 * The rule ".secondary" can be applied to any component.
	 * <p>
	 * To have similar behavior as in CSS, first the rule without type is applied,
	 * then the rule with type.
	 * E.g. setting style class to "foo" on a {@code JButton} uses rules
	 * from UI default keys "[style].foo" and "[style]Button.foo".
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.String}, {@code String[]} or {@link java.util.List}&lt;String&gt;<br>
	 *
	 * @since 2
	 */
	String STYLE_CLASS = "FlatLaf.styleClass";

	/**
	 * Specifies minimum width of a component.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JButton}, {@link javax.swing.JToggleButton},
	 * {@link javax.swing.JComboBox}, {@link javax.swing.JSpinner} and {@link javax.swing.text.JTextComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 */
	String MINIMUM_WIDTH = "JComponent.minimumWidth";

	/**
	 * Specifies minimum height of a component.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JButton} and {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 */
	String MINIMUM_HEIGHT = "JComponent.minimumHeight";

	/**
	 * Paint the component with round edges.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JComboBox}, {@link javax.swing.JSpinner},
	 * {@link javax.swing.JTextField}, {@link javax.swing.JFormattedTextField} and {@link javax.swing.JPasswordField}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String COMPONENT_ROUND_RECT = "JComponent.roundRect";

	/**
	 * Specifies the outline color of the component border.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.JButton}, {@link javax.swing.JComboBox},
	 * {@link javax.swing.JFormattedTextField}, {@link javax.swing.JPasswordField},
	 * {@link javax.swing.JScrollPane}, {@link javax.swing.JSpinner},
	 * {@link javax.swing.JTextField} and {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.String} or {@link java.awt.Color} or {@link java.awt.Color}[2]<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #OUTLINE_ERROR},
	 *     {@link #OUTLINE_WARNING},
	 *     {@link #OUTLINE_SUCCESS},
	 *     any color (type {@link java.awt.Color}) or
	 *     an array of two colors (type {@link java.awt.Color}[2]) where the first color
	 *     is for focused state and the second for unfocused state
	 */
	String OUTLINE = "JComponent.outline";

	/**
	 * Paint the component border in another color (usually reddish) to indicate an error.
	 *
	 * @see #OUTLINE
	 */
	String OUTLINE_ERROR = "error";

	/**
	 * Paint the component border in another color (usually yellowish) to indicate a warning.
	 *
	 * @see #OUTLINE
	 */
	String OUTLINE_WARNING = "warning";

	/**
	 * Paint the component border in another color (usually greenish) to indicate a success.
	 *
	 * @see #OUTLINE
	 * @since 3.6
	 */
	String OUTLINE_SUCCESS = "success";

	/**
	 * Specifies a callback that is invoked to check whether a component is permanent focus owner.
	 * Used to paint focus indicators.
	 * <p>
	 * May be useful in special cases for custom components.
	 * <p>
	 * Use a {@link java.util.function.Predicate} that receives the component as parameter:
	 * <pre>{@code
	 * myComponent.putClientProperty( "JComponent.focusOwner",
	 *     (Predicate<JComponent>) c -> {
	 *         return ...; // check here
	 *     } );
	 * }</pre>
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.util.function.Predicate}&lt;javax.swing.JComponent&gt;
	 */
	String COMPONENT_FOCUS_OWNER = "JComponent.focusOwner";

	/**
	 * Specifies whether a component shown in a window title bar area should behave as caption
	 * (left-click allows moving window, right-click shows window system menu).
	 * The caption component does not receive mouse pressed/released/clicked/dragged events,
	 * but it gets mouse entered/exited/moved events.
	 * <p>
	 * Since 3.4, this client property also supports using a function that can check
	 * whether a given location in the component should behave as caption.
	 * Useful for components that do not use mouse input on whole component bounds.
	 *
	 * <pre>{@code
	 * myComponent.putClientProperty( "JComponent.titleBarCaption",
	 *     (Function<Point, Boolean>) pt -> {
	 *         // parameter pt contains mouse location (in myComponent coordinates)
	 *         // return true if the component is not interested in mouse input at the given location
	 *         // return false if the component wants process mouse input at the given location
	 *         // return null if the component children should be checked
	 *         return ...; // check here
	 *     } );
	 * }</pre>
	 * <b>Warning</b>:
	 * <ul>
	 *   <li>This function is invoked often when mouse is moved over window title bar area
	 *       and should therefore return quickly.
	 *   <li>This function is invoked on 'AWT-Windows' thread (not 'AWT-EventQueue' thread)
	 *       while processing Windows messages.
	 *       It <b>must not</b> change any component property or layout because this could cause a dead lock.
	 * </ul>
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean} or {@link java.util.function.Function}&lt;Point, Boolean&gt;
	 *
	 * @since 2.5
	 */
	String COMPONENT_TITLE_BAR_CAPTION = "JComponent.titleBarCaption";


	//---- Panel --------------------------------------------------------------

	/**
	 * Marks the panel as placeholder for the iconfify/maximize/close buttons
	 * in fullWindowContent mode. See {@link #FULL_WINDOW_CONTENT}.
	 * <p>
	 * If fullWindowContent mode is enabled, the preferred size of the panel is equal
	 * to the size of the iconfify/maximize/close buttons. Otherwise is is {@code 0,0}.
	 * <p>
	 * You're responsible to layout that panel at the top-left or top-right corner,
	 * depending on platform, where the iconfify/maximize/close buttons are located.
	 * <p>
	 * Syntax of the value string is: {@code "win|mac [horizontal|vertical] [zeroInFullScreen] [leftToRight|rightToLeft]"}.
	 * <p>
	 * The string must start with {@code "win"} (for Windows or Linux) or
	 * with {@code "mac"} (for macOS) and specifies the platform where the placeholder
	 * should be used. On macOS, you need the placeholder in the top-left corner,
	 * but on Windows/Linux you need it in the top-right corner. So if your application supports
	 * fullWindowContent mode on both platforms, you can add two placeholders to your layout
	 * and FlatLaf automatically uses only one of them. The other gets size {@code 0,0}.
	 * <p>
	 * Optionally, you can append following options to the value string (separated by space characters):
	 * <ul>
	 *   <li>{@code "horizontal"} - preferred height is zero
	 *   <li>{@code "vertical"} - preferred width is zero
	 *   <li>{@code "zeroInFullScreen"} - in full-screen mode on macOS, preferred size is {@code 0,0}
	 *   <li>{@code "leftToRight"} - in right-to-left component orientation, preferred size is {@code 0,0}
	 *   <li>{@code "rightToLeft"} - in left-to-right component orientation, preferred size is {@code 0,0}
	 * </ul>
	 *
	 * Example for adding placeholder to top-left corner on macOS:
	 * <pre>{@code
	 * JPanel placeholder = new JPanel();
	 * placeholder.putClientProperty( FlatClientProperties.FULL_WINDOW_CONTENT_BUTTONS_PLACEHOLDER, "mac" );
     *
     * JToolBar toolBar = new JToolBar();
     * // add tool bar items
     *
	 * JPanel toolBarPanel = new JPanel( new BorderLayout() );
	 * toolBarPanel.add( placeholder, BorderLayout.WEST );
	 * toolBarPanel.add( toolBar, BorderLayout.CENTER );
	 *
	 * frame.getContentPane().add( toolBarPanel, BorderLayout.NORTH );
	 * }</pre>
	 *
	 * Or add placeholder as first item to the tool bar:
	 * <pre>{@code
	 * JPanel placeholder = new JPanel();
	 * placeholder.putClientProperty( FlatClientProperties.FULL_WINDOW_CONTENT_BUTTONS_PLACEHOLDER, "mac" );
	 *
	 * JToolBar toolBar = new JToolBar();
	 * toolBar.add( placeholder );
	 * // add tool bar items
	 *
	 * frame.getContentPane().add( toolBar, BorderLayout.NORTH );
	 * }</pre>
	 *
	 * If a tabbed pane is located at the top, you can add the placeholder
	 * as leading component to that tabbed pane:
	 * <pre>{@code
	 * JPanel placeholder = new JPanel();
	 * placeholder.putClientProperty( FlatClientProperties.FULL_WINDOW_CONTENT_BUTTONS_PLACEHOLDER, "mac" );
	 *
	 * tabbedPane.putClientProperty( FlatClientProperties.TABBED_PANE_LEADING_COMPONENT, placeholder );
	 * }</pre>
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JPanel}<br>
	 * <strong>Value type</strong> {@link java.lang.String}
	 *
	 * @since 3.4
	 */
	String FULL_WINDOW_CONTENT_BUTTONS_PLACEHOLDER = "FlatLaf.fullWindowContent.buttonsPlaceholder";


	//---- Popup --------------------------------------------------------------

	/**
	 * Specifies the popup border corner radius if the component is shown in a popup
	 * or if the component is the owner of another component that is shown in a popup.
	 * <p>
	 * Note that this is not available on all platforms since it requires special support.
	 * Supported platforms:
	 * <ul>
	 * <li><strong>Windows 11</strong>: Only two corner radiuses are supported
	 *     by the OS: {@code DWMWCP_ROUND} is 8px and {@code DWMWCP_ROUNDSMALL} is 4px.
	 *     If this value is {@code 1 - 4}, then {@code DWMWCP_ROUNDSMALL} is used.
	 *     If it is {@code >= 5}, then {@code DWMWCP_ROUND} is used.
	 * <li><strong>macOS</strong> (10.14 and later): Any corner radius is supported.
	 * </ul>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}<br>
	 *
	 * @since 3.1
	 */
	String POPUP_BORDER_CORNER_RADIUS = "Popup.borderCornerRadius";

	/**
	 * Specifies the popup rounded border width if the component is shown in a popup
	 * or if the component is the owner of another component that is shown in a popup.
	 * <p>
	 * Only used if popup uses rounded border.
	 * <p>
	 * Note that this is not available on all platforms since it requires special support.
	 * Supported platforms:
	 * <ul>
	 * <li><strong>macOS</strong> (10.14 and later)
	 * </ul>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer} or {@link java.lang.Float}<br>
	 *
	 * @since 3.3
	 */
	String POPUP_ROUNDED_BORDER_WIDTH = "Popup.roundedBorderWidth";

	/**
	 * Specifies whether a drop shadow is painted if the component is shown in a popup
	 * or if the component is the owner of another component that is shown in a popup.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String POPUP_DROP_SHADOW_PAINTED = "Popup.dropShadowPainted";

	/**
	 * Specifies whether a heavy weight window should be used if the component is shown in a popup
	 * or if the component is the owner of another component that is shown in a popup.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JComponent}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String POPUP_FORCE_HEAVY_WEIGHT = "Popup.forceHeavyWeight";


	//---- JProgressBar -------------------------------------------------------

	/**
	 * Specifies whether the progress bar has always the larger height even if no string is painted.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JProgressBar}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String PROGRESS_BAR_LARGE_HEIGHT = "JProgressBar.largeHeight";

	/**
	 * Specifies whether the progress bar is paint with square edges.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JProgressBar}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String PROGRESS_BAR_SQUARE = "JProgressBar.square";


	//---- JRootPane ----------------------------------------------------------

	/**
	 * Specifies whether FlatLaf native window decorations should be used
	 * for {@code JFrame} or {@code JDialog}.
	 * <p>
	 * Setting this enables/disables using FlatLaf native window decorations
	 * for the window that contains the root pane.
	 * <p>
	 * This client property has lower priority than system property
	 * {@link FlatSystemProperties#USE_WINDOW_DECORATIONS}, but higher priority
	 * than UI default {@code TitlePane.useWindowDecorations}.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 1.1.1
	 */
	String USE_WINDOW_DECORATIONS = "JRootPane.useWindowDecorations";

	/**
	 * Specifies whether the menu bar is embedded into the window title pane
	 * if window decorations are enabled.
	 * <p>
	 * Setting this enables/disables embedding
	 * for the window that contains the root pane.
	 * <p>
	 * This client property has lower priority than system property
	 * {@link FlatSystemProperties#MENUBAR_EMBEDDED}, but higher priority
	 * than UI default {@code TitlePane.menuBarEmbedded}.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String MENU_BAR_EMBEDDED = "JRootPane.menuBarEmbedded";

	/**
	 * Specifies whether the content pane (and the glass pane) should be extended
	 * into the window title bar area
	 * (requires enabled window decorations). Default is {@code false}.
	 * <p>
	 * On macOS, use client property {@code apple.awt.fullWindowContent}
	 * (see <a href="https://www.formdev.com/flatlaf/macos/#full_window_content">macOS Full window content</a>).
	 * <p>
	 * Setting this enables/disables full window content
	 * for the {@code JFrame} or {@code JDialog} that contains the root pane.
	 * <p>
	 * If {@code true}, the content pane (and the glass pane) is extended into
	 * the title bar area. The window icon and title are hidden.
	 * Only the iconfify/maximize/close buttons stay visible in the upper right corner
	 * (and overlap the content pane).
	 * <p>
	 * The user can left-click-and-drag on the title bar area to move the window,
	 * except when clicking on a component that processes mouse events (e.g. buttons or menus).
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3.4
	 */
	String FULL_WINDOW_CONTENT = "FlatLaf.fullWindowContent";

	/**
	 * Contains the current bounds of the iconfify/maximize/close buttons
	 * (in root pane coordinates) if fullWindowContent mode is enabled.
	 * Otherwise its value is {@code null}.
	 * <p>
	 * <b>Note</b>: Do not set this client property. It is set by FlatLaf.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Rectangle}
	 *
	 * @since 3.4
	 */
	String FULL_WINDOW_CONTENT_BUTTONS_BOUNDS = "FlatLaf.fullWindowContent.buttonsBounds";

	/**
	 * Specifies whether the window icon should be shown in the window title bar
	 * (requires enabled window decorations). Default is UI property {@code TitlePane.showIcon}.
	 * <p>
	 * Setting this shows/hides the windows icon
	 * for the {@code JFrame} or {@code JDialog} that contains the root pane.
	 * <p>
	 * This client property has higher priority than UI default {@code TitlePane.showIcon}.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 2
	 */
	String TITLE_BAR_SHOW_ICON = "JRootPane.titleBarShowIcon";

	/**
	 * Specifies whether the window title should be shown in the window title bar
	 * (requires enabled window decorations). Default is {@code true}.
	 * <p>
	 * Setting this shows/hides the windows title
	 * for the {@code JFrame} or {@code JDialog} that contains the root pane.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3
	 */
	String TITLE_BAR_SHOW_TITLE = "JRootPane.titleBarShowTitle";

	/**
	 * Specifies whether the "iconify" button should be shown in the window title bar
	 * (requires enabled window decorations). Default is {@code true}.
	 * <p>
	 * Setting this shows/hides the "iconify" button
	 * for the {@code JFrame} that contains the root pane.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3
	 */
	String TITLE_BAR_SHOW_ICONIFFY = "JRootPane.titleBarShowIconify";

	/**
	 * Specifies whether the "maximize/restore" button should be shown in the window title bar
	 * (requires enabled window decorations). Default is {@code true}.
	 * <p>
	 * Setting this shows/hides the "maximize/restore" button
	 * for the {@code JFrame} that contains the root pane.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3
	 */
	String TITLE_BAR_SHOW_MAXIMIZE = "JRootPane.titleBarShowMaximize";

	/**
	 * Specifies whether the "close" button should be shown in the window title bar
	 * (requires enabled window decorations). Default is {@code true}.
	 * <p>
	 * Setting this shows/hides the "close" button
	 * for the {@code JFrame} or {@code JDialog} that contains the root pane.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3
	 */
	String TITLE_BAR_SHOW_CLOSE = "JRootPane.titleBarShowClose";

	/**
	 * Background color of window title bar (requires enabled window decorations).
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Color}
	 *
	 * @since 1.1.2
	 */
	String TITLE_BAR_BACKGROUND = "JRootPane.titleBarBackground";

	/**
	 * Foreground color of window title bar (requires enabled window decorations).
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Color}
	 *
	 * @since 1.1.2
	 */
	String TITLE_BAR_FOREGROUND = "JRootPane.titleBarForeground";

	/**
	 * Specifies the preferred height of title bar (requires enabled window decorations).
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 *
	 * @since 3.5.2
	 */
	String TITLE_BAR_HEIGHT = "JRootPane.titleBarHeight";

	/**
	 * Specifies whether the glass pane should have full height and overlap the title bar,
	 * if FlatLaf window decorations are enabled. Default is {@code false}.
	 * <p>
	 * (requires Windows 10/11)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3.1
	 */
	String GLASS_PANE_FULL_HEIGHT = "JRootPane.glassPaneFullHeight";

	/**
	 * Specifies the style of the window title bar.
	 * Besides the default title bar style, you can use a Utility-style title bar,
	 * which is smaller than the default title bar.
	 * <p>
	 * On Windows 10/11, this requires FlatLaf window decorations.
	 * On macOS, Java supports this out of the box.
	 * <p>
	 * Note that this client property must be set before the window becomes displayable.
	 * Otherwise, an {@link IllegalComponentStateException} is thrown.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #WINDOW_STYLE_SMALL}
	 *
	 * @since 3.2
	 */
	String WINDOW_STYLE = "Window.style";

	/**
	 * The window has Utility-style title bar, which is smaller than default title bar.
	 * <p>
	 * This is the same as using {@link Window#setType}( {@link Window.Type#UTILITY} ).
	 *
	 * @see #WINDOW_STYLE
	 * @since 3.2
	 */
	String WINDOW_STYLE_SMALL = "small";


	//---- JScrollBar / JScrollPane -------------------------------------------

	/**
	 * Specifies whether the decrease/increase arrow buttons of a scrollbar are shown.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JScrollBar} or {@link javax.swing.JScrollPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String SCROLL_BAR_SHOW_BUTTONS = "JScrollBar.showButtons";

	/**
	 * Specifies whether the scroll pane uses smooth scrolling.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JScrollPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String SCROLL_PANE_SMOOTH_SCROLLING = "JScrollPane.smoothScrolling";


	//---- JSplitPane ---------------------------------------------------------

	/**
	 * Specifies what side of the spilt pane is allowed to expand
	 * via one-touch expanding arrow buttons.
	 * Requires that one-touch expanding is enabled with
	 * {@link javax.swing.JSplitPane#setOneTouchExpandable(boolean)}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JSplitPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #SPLIT_PANE_EXPANDABLE_SIDE_LEFT} or
	 *     {@link #SPLIT_PANE_EXPANDABLE_SIDE_RIGHT}
	 *
	 * @since 2.2
	 */
	String SPLIT_PANE_EXPANDABLE_SIDE = "JSplitPane.expandableSide";

	/**
	 * Allow expanding only left/top side of the split pane.
	 *
	 * @see #SPLIT_PANE_EXPANDABLE_SIDE
	 * @since 2.2
	 */
	String SPLIT_PANE_EXPANDABLE_SIDE_LEFT = "left";

	/**
	 * Allow expanding only right/bottom side of the split pane.
	 *
	 * @see #SPLIT_PANE_EXPANDABLE_SIDE
	 * @since 2.2
	 */
	String SPLIT_PANE_EXPANDABLE_SIDE_RIGHT = "right";


	//---- JTabbedPane --------------------------------------------------------

	/**
	 * Specifies type of the selected tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #TABBED_PANE_TAB_TYPE_UNDERLINED} or
	 *     {@link #TABBED_PANE_TAB_TYPE_CARD}
	 *
	 * @since 2
	 */
	String TABBED_PANE_TAB_TYPE = "JTabbedPane.tabType";

	/**
	 * Paint the selected tab underlined.
	 *
	 * @see #TABBED_PANE_TAB_TYPE
	 * @since 2
	 */
	String TABBED_PANE_TAB_TYPE_UNDERLINED = "underlined";

	/**
	 * Paint the selected tab as card.
	 *
	 * @see #TABBED_PANE_TAB_TYPE
	 * @since 2
	 */
	String TABBED_PANE_TAB_TYPE_CARD = "card";

	/**
	 * Specifies whether separators are shown between tabs.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TABBED_PANE_SHOW_TAB_SEPARATORS = "JTabbedPane.showTabSeparators";

	/**
	 * Specifies whether the separator between tabs area and content area should be shown.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TABBED_PANE_SHOW_CONTENT_SEPARATOR = "JTabbedPane.showContentSeparator";

	/**
	 * Specifies whether a full border is painted around a tabbed pane.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TABBED_PANE_HAS_FULL_BORDER = "JTabbedPane.hasFullBorder";

	/**
	 * Specifies whether the tab area should be hidden if it contains only one tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TABBED_PANE_HIDE_TAB_AREA_WITH_ONE_TAB = "JTabbedPane.hideTabAreaWithOneTab";

	/**
	 * Specifies the minimum width of a tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 */
	String TABBED_PANE_MINIMUM_TAB_WIDTH = "JTabbedPane.minimumTabWidth";

	/**
	 * Specifies the maximum width of a tab.
	 * <p>
	 * Applied only if tab does not have a custom tab component
	 * (see {@link javax.swing.JTabbedPane#setTabComponentAt(int, java.awt.Component)}).
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 */
	String TABBED_PANE_MAXIMUM_TAB_WIDTH = "JTabbedPane.maximumTabWidth";

	/**
	 * Specifies the minimum height of a tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 *
	 * @see #TABBED_PANE_TAB_INSETS
	 */
	String TABBED_PANE_TAB_HEIGHT = "JTabbedPane.tabHeight";

	/**
	 * Specifies the insets of a tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.awt.Insets}
	 *
	 * @see #TABBED_PANE_TAB_HEIGHT
	 */
	String TABBED_PANE_TAB_INSETS = "JTabbedPane.tabInsets";

	/**
	 * Specifies the insets of the tab area.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Insets}
	 */
	String TABBED_PANE_TAB_AREA_INSETS = "JTabbedPane.tabAreaInsets";

	/**
	 * Specifies whether tabs are closable.
	 * If set to {@code true} on a tabbed pane component, all tabs in that tabbed pane are closable.
	 * To make individual tabs closable, set it to {@code true} on a tab content component.
	 * <p>
	 * Note that you have to specify a callback (see {@link #TABBED_PANE_TAB_CLOSABLE})
	 * that is invoked when the user clicks a tab close button.
	 * The callback is responsible for closing the tab.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @see #TABBED_PANE_TAB_CLOSE_CALLBACK
	 */
	String TABBED_PANE_TAB_CLOSABLE = "JTabbedPane.tabClosable";

	/**
	 * Specifies the tooltip text used for tab close buttons.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.lang.String}
	 *
	 * @see #TABBED_PANE_TAB_CLOSABLE
	 */
	String TABBED_PANE_TAB_CLOSE_TOOLTIPTEXT = "JTabbedPane.tabCloseToolTipText";

	/**
	 * Specifies the callback that is invoked when a tab close button is clicked.
	 * The callback is responsible for closing the tab.
	 * <p>
	 * Either use a {@link java.util.function.IntConsumer} that receives the tab index as parameter:
	 * <pre>{@code
	 * myTabbedPane.putClientProperty( "JTabbedPane.tabCloseCallback",
	 *     (IntConsumer) tabIndex -> {
	 *         // close tab here
	 *     } );
	 * }</pre>
	 * Or use a {@link java.util.function.BiConsumer}&lt;javax.swing.JTabbedPane, Integer&gt;
	 * that receives the tabbed pane and the tab index as parameters:
	 * <pre>{@code
	 * myTabbedPane.putClientProperty( "JTabbedPane.tabCloseCallback",
	 *     (BiConsumer<JTabbedPane, Integer>) (tabbedPane, tabIndex) -> {
	 *         // close tab here
	 *     } );
	 * }</pre>
	 * If you need to check whether a modifier key (e.g. Alt or Shift) was pressed
	 * while the user clicked the tab close button, use {@link java.awt.EventQueue#getCurrentEvent}
	 * to get current event, check whether it is a {@link java.awt.event.MouseEvent}
	 * and invoke its methods. E.g.
	 * <pre>{@code
	 * AWTEvent e = EventQueue.getCurrentEvent();
	 * boolean shift = (e instanceof MouseEvent) ? ((MouseEvent)e).isShiftDown() : false;
	 * }</pre>
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.util.function.IntConsumer}
	 * or {@link java.util.function.BiConsumer}&lt;javax.swing.JTabbedPane, Integer&gt;
	 *
	 * @see #TABBED_PANE_TAB_CLOSABLE
	 */
	String TABBED_PANE_TAB_CLOSE_CALLBACK = "JTabbedPane.tabCloseCallback";

	/**
	 * Specifies the display policy for the "more tabs" button,
	 * which shows a popup menu with the (partly) hidden tabs.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #TABBED_PANE_POLICY_NEVER} or
	 *     {@link #TABBED_PANE_POLICY_AS_NEEDED}
	 */
	String TABBED_PANE_TABS_POPUP_POLICY = "JTabbedPane.tabsPopupPolicy";

	/**
	 * Specifies the display policy for the forward/backward scroll arrow buttons.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #TABBED_PANE_POLICY_NEVER},
	 *     {@link #TABBED_PANE_POLICY_AS_NEEDED} or
	 *     {@link #TABBED_PANE_POLICY_AS_NEEDED_SINGLE}
	 */
	String TABBED_PANE_SCROLL_BUTTONS_POLICY = "JTabbedPane.scrollButtonsPolicy";

	/**
	 * Display never.
	 *
	 * @see #TABBED_PANE_TABS_POPUP_POLICY
	 * @see #TABBED_PANE_SCROLL_BUTTONS_POLICY
	 */
	String TABBED_PANE_POLICY_NEVER = "never";

	/**
	 * Display only when needed.
	 * <p>
	 * If used for {@link #TABBED_PANE_SCROLL_BUTTONS_POLICY}, both scroll arrow buttons
	 * are either shown or hidden. Buttons are disabled if scrolling in that
	 * direction is not applicable.
	 *
	 * @see #TABBED_PANE_TABS_POPUP_POLICY
	 * @see #TABBED_PANE_SCROLL_BUTTONS_POLICY
	 */
	String TABBED_PANE_POLICY_AS_NEEDED = "asNeeded";

	/**
	 * Display single button only when needed.
	 * <p>
	 * If scroll button placement is trailing, then this option is ignored
	 * and both buttons are shown or hidden as needed.
	 *
	 * @see #TABBED_PANE_SCROLL_BUTTONS_POLICY
	 */
	String TABBED_PANE_POLICY_AS_NEEDED_SINGLE = "asNeededSingle";

	/**
	 * Specifies the placement of the forward/backward scroll arrow buttons.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #TABBED_PANE_PLACEMENT_BOTH} or
	 *     {@link #TABBED_PANE_PLACEMENT_TRAILING}
	 */
	String TABBED_PANE_SCROLL_BUTTONS_PLACEMENT = "JTabbedPane.scrollButtonsPlacement";

	/**
	 * The forward/backward scroll arrow buttons are placed on both sides of the tab area.
	 * The backward scroll button at the left/top side.
	 * The forward scroll button at the right/bottom side.
	 *
	 * @see #TABBED_PANE_SCROLL_BUTTONS_PLACEMENT
	 */
	String TABBED_PANE_PLACEMENT_BOTH = "both";

	/**
	 * The forward/backward scroll arrow buttons are placed on the trailing side of the tab area.
	 *
	 * @see #TABBED_PANE_SCROLL_BUTTONS_PLACEMENT
	 */
	String TABBED_PANE_PLACEMENT_TRAILING = "trailing";

	/**
	 * Specifies the alignment of the tab area.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer} or {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link SwingConstants#LEADING} (default),
	 *     {@link SwingConstants#TRAILING},
	 *     {@link SwingConstants#CENTER},
	 *     {@link #TABBED_PANE_ALIGN_LEADING} (default),
	 *     {@link #TABBED_PANE_ALIGN_TRAILING},
	 *     {@link #TABBED_PANE_ALIGN_CENTER} or
	 *     {@link #TABBED_PANE_ALIGN_FILL}
	 */
	String TABBED_PANE_TAB_AREA_ALIGNMENT = "JTabbedPane.tabAreaAlignment";

	/**
	 * Specifies the horizontal alignment of the tab title and icon.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}
	 * or tab content components (see {@link javax.swing.JTabbedPane#setComponentAt(int, java.awt.Component)})<br>
	 * <strong>Value type</strong> {@link java.lang.Integer} or {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link SwingConstants#LEADING},
	 *     {@link SwingConstants#TRAILING},
	 *     {@link SwingConstants#CENTER} (default),
	 *     {@link #TABBED_PANE_ALIGN_LEADING},
	 *     {@link #TABBED_PANE_ALIGN_TRAILING} or
	 *     {@link #TABBED_PANE_ALIGN_CENTER} (default)
	 */
	String TABBED_PANE_TAB_ALIGNMENT = "JTabbedPane.tabAlignment";

	/**
	 * Align to the leading edge.
	 *
	 * @see #TABBED_PANE_TAB_AREA_ALIGNMENT
	 * @see #TABBED_PANE_TAB_ALIGNMENT
	 */
	String TABBED_PANE_ALIGN_LEADING = "leading";

	/**
	 * Align to the trailing edge.
	 *
	 * @see #TABBED_PANE_TAB_AREA_ALIGNMENT
	 * @see #TABBED_PANE_TAB_ALIGNMENT
	 */
	String TABBED_PANE_ALIGN_TRAILING = "trailing";

	/**
	 * Align to center.
	 *
	 * @see #TABBED_PANE_TAB_AREA_ALIGNMENT
	 * @see #TABBED_PANE_TAB_ALIGNMENT
	 */
	String TABBED_PANE_ALIGN_CENTER = "center";

	/**
	 * Stretch to fill all available space.
	 *
	 * @see #TABBED_PANE_TAB_AREA_ALIGNMENT
	 */
	String TABBED_PANE_ALIGN_FILL = "fill";

	/**
	 * Specifies how the tabs should be sized.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #TABBED_PANE_TAB_WIDTH_MODE_PREFERRED} (default),
	 *     {@link #TABBED_PANE_TAB_WIDTH_MODE_EQUAL} or
	 *     {@link #TABBED_PANE_TAB_WIDTH_MODE_COMPACT}
	 */
	String TABBED_PANE_TAB_WIDTH_MODE = "JTabbedPane.tabWidthMode";

	/**
	 * Tab width is adjusted to tab icon and title.
	 *
	 * @see #TABBED_PANE_TAB_WIDTH_MODE
	 */
	String TABBED_PANE_TAB_WIDTH_MODE_PREFERRED = "preferred";

	/**
	 * All tabs in a tabbed pane has same width.
	 *
	 * @see #TABBED_PANE_TAB_WIDTH_MODE
	 */
	String TABBED_PANE_TAB_WIDTH_MODE_EQUAL = "equal";

	/**
	 * Unselected tabs are smaller because they show only the tab icon, but no tab title.
	 * Selected tabs show both.
	 *
	 * @see #TABBED_PANE_TAB_WIDTH_MODE
	 */
	String TABBED_PANE_TAB_WIDTH_MODE_COMPACT = "compact";

	/**
	 * Specifies the tab icon placement (relative to tab title).
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link SwingConstants#LEADING} (default),
	 *     {@link SwingConstants#TRAILING},
	 *     {@link SwingConstants#TOP} or
	 *     {@link SwingConstants#BOTTOM}
	 */
	String TABBED_PANE_TAB_ICON_PLACEMENT = "JTabbedPane.tabIconPlacement";

	/**
	 * Specifies the rotation of the tabs (title, icon, etc.).
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer} or {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link SwingConstants#LEFT},
	 *     {@link SwingConstants#RIGHT},
	 *     {@link #TABBED_PANE_TAB_ROTATION_NONE} (default),
	 *     {@link #TABBED_PANE_TAB_ROTATION_AUTO},
	 *     {@link #TABBED_PANE_TAB_ROTATION_LEFT} or
	 *     {@link #TABBED_PANE_TAB_ROTATION_RIGHT}
	 *
	 * @since 3.3
	 */
	String TABBED_PANE_TAB_ROTATION = "JTabbedPane.tabRotation";

	/**
	 * Tabs are not rotated.
	 *
	 * @see #TABBED_PANE_TAB_ROTATION
	 * @since 3.3
	 */
	String TABBED_PANE_TAB_ROTATION_NONE = "none";

	/**
	 * Tabs are rotated depending on tab placement.
	 * <p>
	 * For top and bottom tab placement, the tabs are not rotated.<br>
	 * For left tab placement, the tabs are rotated counter-clockwise.<br>
	 * For right tab placement, the tabs are rotated clockwise.
	 *
	 * @see #TABBED_PANE_TAB_ROTATION
	 * @since 3.3
	 */
	String TABBED_PANE_TAB_ROTATION_AUTO = "auto";

	/**
	 * Tabs are rotated counter-clockwise.
	 *
	 * @see #TABBED_PANE_TAB_ROTATION
	 * @since 3.3
	 */
	String TABBED_PANE_TAB_ROTATION_LEFT = "left";

	/**
	 * Tabs are rotated clockwise.
	 *
	 * @see #TABBED_PANE_TAB_ROTATION
	 * @since 3.3
	 */
	String TABBED_PANE_TAB_ROTATION_RIGHT = "right";

	/**
	 * Specifies a component that will be placed at the leading edge of the tabs area.
	 * <p>
	 * For top and bottom tab placement, the laid out component size will be
	 * the preferred component width and the tab area height.<br>
	 * For left and right tab placement, the laid out component size will be
	 * the tab area width and the preferred component height.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Component}
	 */
	String TABBED_PANE_LEADING_COMPONENT = "JTabbedPane.leadingComponent";

	/**
	 * Specifies a component that will be placed at the trailing edge of the tabs area.
	 * <p>
	 * For top and bottom tab placement, the laid out component size will be
	 * the available horizontal space (minimum is preferred component width) and the tab area height.<br>
	 * For left and right tab placement, the laid out component size will be
	 * the tab area width and the available vertical space (minimum is preferred component height).
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTabbedPane}<br>
	 * <strong>Value type</strong> {@link java.awt.Component}
	 */
	String TABBED_PANE_TRAILING_COMPONENT = "JTabbedPane.trailingComponent";


	//---- JTextField ---------------------------------------------------------

	/**
	 * Specifies whether all text is selected when the text component gains focus.
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.text.JTextComponent} (and subclasses),
	 * {@link javax.swing.JComboBox} (since 3.6) and {@link javax.swing.JSpinner} (since 3.6)<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #SELECT_ALL_ON_FOCUS_POLICY_NEVER},
	 *     {@link #SELECT_ALL_ON_FOCUS_POLICY_ONCE} (default) or
	 *     {@link #SELECT_ALL_ON_FOCUS_POLICY_ALWAYS}
	 *
	 * @see #SELECT_ALL_ON_MOUSE_CLICK
	 */
	String SELECT_ALL_ON_FOCUS_POLICY = "JTextField.selectAllOnFocusPolicy";

	/**
	 * Never select all text when the text component gains focus.
	 *
	 * @see #SELECT_ALL_ON_FOCUS_POLICY
	 */
	String SELECT_ALL_ON_FOCUS_POLICY_NEVER = "never";

	/**
	 * Select all text when the text component gains focus for the first time
	 * and selection was not modified (is at end of text).
	 * This is the default.
	 * <p>
	 * <b>Limitations:</b>
	 * For {@link JFormattedTextField} and {@link JSpinner} this behaves
	 * as {@link #SELECT_ALL_ON_FOCUS_POLICY_ALWAYS}.
     * This is because of special behavior of {@link JFormattedTextField}
     * that did not allow implementation of {@code "once"}.
	 *
	 * @see #SELECT_ALL_ON_FOCUS_POLICY
	 */
	String SELECT_ALL_ON_FOCUS_POLICY_ONCE = "once";

	/**
	 * Always select all text when the text component gains focus.
	 *
	 * @see #SELECT_ALL_ON_FOCUS_POLICY
	 */
	String SELECT_ALL_ON_FOCUS_POLICY_ALWAYS = "always";

	/**
	 * Specifies whether all text is selected when when clicking with the mouse
	 * into the text field (and if "select all on focus" policy is enabled).
	 * <p>
	 * <strong>Components</strong> {@link javax.swing.text.JTextComponent} (and subclasses),
	 * {@link javax.swing.JComboBox} and {@link javax.swing.JSpinner}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @see #SELECT_ALL_ON_FOCUS_POLICY
	 * @since 3.6
	 */
	String SELECT_ALL_ON_MOUSE_CLICK = "JTextField.selectAllOnMouseClick";

	/**
	 * Placeholder text that is only painted if the text field is empty.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses) or {@link javax.swing.JComboBox}<br>
	 * <strong>Value type</strong> {@link java.lang.String}
	 */
	String PLACEHOLDER_TEXT = "JTextField.placeholderText";

	/**
	 * Specifies the padding of the text.
	 * This changes the location and size of the text view within the component bounds,
	 * but does not affect the size of the component.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link java.awt.Insets}
	 *
	 * @since 1.4
	 */
	String TEXT_FIELD_PADDING = "JTextField.padding";

	/**
	 * Specifies an icon that will be placed at the leading edge of the text field.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link javax.swing.Icon}
	 *
	 * @since 2
	 */
	String TEXT_FIELD_LEADING_ICON = "JTextField.leadingIcon";

	/**
	 * Specifies an icon that will be placed at the trailing edge of the text field.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link javax.swing.Icon}
	 *
	 * @since 2
	 */
	String TEXT_FIELD_TRAILING_ICON = "JTextField.trailingIcon";

	/**
	 * Specifies a component that will be placed at the leading edge of the text field.
	 * <p>
	 * The component will be positioned inside and aligned to the visible text field border.
	 * There is no gap between the visible border and the component.
	 * The laid out component size will be the preferred component width
	 * and the inner text field height.
	 * <p>
	 * The component should be not opaque because the text field border is painted
	 * slightly inside the usually visible border in some cases.
	 * E.g. when focused (in some themes) or when an outline color is specified
	 * (see {@link #OUTLINE}).
	 * <p>
	 * The component is prepared in the following way:
	 * <ul>
	 * <li>Component client property {@link #STYLE_CLASS} is set to {@code inTextField}.
	 * <li>If component is a button or toggle button, client property {@link #BUTTON_TYPE}
	 *     is set to {@link #BUTTON_TYPE_TOOLBAR_BUTTON}
	 *     and button cursor is set to default cursor (if not set).
	 * <li>If component is a toolbar, client property {@link #STYLE_CLASS}
	 *     is set to {@code inTextField} on all toolbar children
	 *     and toolbar cursor is set to default cursor (if not set).
	 * </ul>
	 * Because text fields use the text cursor by default and the cursor is inherited by child components,
	 * it may be necessary to explicitly set component cursor if you e.g. need the default arrow cursor.
	 * E.g. {@code comp.setCursor( Cursor.getDefaultCursor() )}.
	 * <p>
	 * Styling is used to modify insets/margins and appearance of buttons and toolbars
	 * so that they fit nicely into the text field and do not increase text field height.
	 * See styles {@code [style]Button.inTextField} and {@code [style]ToolBar.inTextField}
	 * in {@code Flat[Light|Dark]Laf.properties}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link javax.swing.JComponent}
	 *
	 * @since 2
	 */
	String TEXT_FIELD_LEADING_COMPONENT = "JTextField.leadingComponent";

	/**
	 * Specifies a component that will be placed at the trailing edge of the text field.
	 * <p>
	 * See {@link #TEXT_FIELD_LEADING_COMPONENT} for details.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link javax.swing.JComponent}
	 *
	 * @since 2
	 */
	String TEXT_FIELD_TRAILING_COMPONENT = "JTextField.trailingComponent";

	/**
	 * Specifies whether a "clear" (or "cancel") button is shown on the trailing side
	 * if the text field is not empty, editable and enabled. Default is {@code false}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 2
	 */
	String TEXT_FIELD_SHOW_CLEAR_BUTTON = "JTextField.showClearButton";

	/**
	 * Specifies the callback that is invoked when a "clear" (or "cancel") button is clicked.
	 * If a callback is specified than it is responsible for clearing the text field.
	 * Without callback, the text field clears itself.
	 * <p>
	 * Either use a {@link java.lang.Runnable}:
	 * <pre>{@code
	 * myTextField.putClientProperty( "JTextField.clearCallback",
	 *     (Runnable) () -> {
	 *         // clear field here or cancel search
	 *     } );
	 * }</pre>
	 * Or use a {@link java.util.function.Consumer}&lt;javax.swing.text.JTextComponent&gt;
	 * that receives the text field as parameter:
	 * <pre>{@code
	 * myTextField.putClientProperty( "JTextField.clearCallback",
	 *     (Consumer<JTextComponent>) textField -> {
	 *         // clear field here or cancel search
	 *     } );
	 * }</pre>
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTextField} (and subclasses)<br>
	 * <strong>Value type</strong> {@link java.lang.Runnable}
	 * or {@link java.util.function.Consumer}&lt;javax.swing.text.JTextComponent&gt;
	 *
	 * @see #TEXT_FIELD_SHOW_CLEAR_BUTTON
	 * @since 2
	 */
	String TEXT_FIELD_CLEAR_CALLBACK = "JTextField.clearCallback";


	//---- JToggleButton ------------------------------------------------------

	/**
	 * Placement of underline if toggle button type is {@link #BUTTON_TYPE_TAB}
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link SwingConstants#BOTTOM} (default),
	 *     {@link SwingConstants#TOP},
	 *     {@link SwingConstants#LEFT} or
	 *     {@link SwingConstants#RIGHT}
	 *
	 * @since 2.3
	 */
	String TAB_BUTTON_UNDERLINE_PLACEMENT = "JToggleButton.tab.underlinePlacement";

	/**
	 * Thickness of underline if toggle button type is {@link #BUTTON_TYPE_TAB}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.lang.Integer}
	 */
	String TAB_BUTTON_UNDERLINE_HEIGHT = "JToggleButton.tab.underlineHeight";

	/**
	 * Color of underline if toggle button type is {@link #BUTTON_TYPE_TAB}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.awt.Color}
	 */
	String TAB_BUTTON_UNDERLINE_COLOR = "JToggleButton.tab.underlineColor";

	/**
	 * Background color if selected and toggle button type is {@link #BUTTON_TYPE_TAB}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JToggleButton}<br>
	 * <strong>Value type</strong> {@link java.awt.Color}
	 */
	String TAB_BUTTON_SELECTED_BACKGROUND = "JToggleButton.tab.selectedBackground";


	//---- JTree --------------------------------------------------------------

	/**
	 * Specifies whether tree shows a wide selection. Default is {@code true}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTree}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TREE_WIDE_SELECTION = "JTree.wideSelection";

	/**
	 * Specifies whether tree uses a wide cell renderer. Default is {@code false}.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTree}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 *
	 * @since 3.6
	 */
	String TREE_WIDE_CELL_RENDERER = "JTree.wideCellRenderer";

	/**
	 * Specifies whether tree item selection is painted. Default is {@code true}.
	 * If set to {@code false}, then the tree cell renderer is responsible for painting selection.
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JTree}<br>
	 * <strong>Value type</strong> {@link java.lang.Boolean}
	 */
	String TREE_PAINT_SELECTION = "JTree.paintSelection";


	//---- macOS --------------------------------------------------------------

	/**
	 * Specifies the spacing around the macOS window close/minimize/zoom buttons.
	 * Useful if <a href="https://www.formdev.com/flatlaf/macos/#full_window_content">full window content</a>
	 * is enabled.
	 * <p>
	 * (requires macOS 10.14+ for "medium" spacing and macOS 11+ for "large" spacing, requires Java 17+)
	 * <p>
	 * <strong>Component</strong> {@link javax.swing.JRootPane}<br>
	 * <strong>Value type</strong> {@link java.lang.String}<br>
	 * <strong>Allowed Values</strong>
	 *     {@link #MACOS_WINDOW_BUTTONS_SPACING_MEDIUM} or
	 *     {@link #MACOS_WINDOW_BUTTONS_SPACING_LARGE} (requires macOS 11+)
	 *
	 * @since 3.4
	 */
	String MACOS_WINDOW_BUTTONS_SPACING = "FlatLaf.macOS.windowButtonsSpacing";

	/**
	 * Add medium spacing around the macOS window close/minimize/zoom buttons.
	 *
	 * @see #MACOS_WINDOW_BUTTONS_SPACING
	 * @since 3.4
	 */
	String MACOS_WINDOW_BUTTONS_SPACING_MEDIUM = "medium";

	/**
	 * Add large spacing around the macOS window close/minimize/zoom buttons.
	 * <p>
	 * (requires macOS 11+; "medium" is used on older systems)
	 *
	 * @see #MACOS_WINDOW_BUTTONS_SPACING
	 * @since 3.4
	 */
	String MACOS_WINDOW_BUTTONS_SPACING_LARGE = "large";


	//---- helper methods -----------------------------------------------------

	/**
	 * Checks whether a client property of a component has the given value.
	 */
	static boolean clientPropertyEquals( JComponent c, String key, Object value ) {
		return Objects.equals( c.getClientProperty( key ), value );
	}

	/**
	 * Checks whether a client property of a component is a boolean and returns its value.
	 * If the client property is not set, or not a boolean, defaultValue is returned.
	 */
	static boolean clientPropertyBoolean( JComponent c, String key, boolean defaultValue ) {
		Object value = c.getClientProperty( key );
		return (value instanceof Boolean) ? (boolean) value : defaultValue;
	}

	/**
	 * Checks whether a client property of a component is a {@link Boolean} and returns its value.
	 * If the client property is not set, or not a {@link Boolean}, defaultValue is returned.
	 */
	static Boolean clientPropertyBooleanStrict( JComponent c, String key, Boolean defaultValue ) {
		return clientProperty( c, key, defaultValue, Boolean.class );
	}

	/**
	 * Checks whether a client property of a component is an integer and returns its value.
	 * If the client property is not set, or not an integer, defaultValue is returned.
	 */
	static int clientPropertyInt( JComponent c, String key, int defaultValue ) {
		Object value = c.getClientProperty( key );
		return (value instanceof Integer) ? (int) value : defaultValue;
	}

	/**
	 * Checks whether a client property of a component is a color and returns its value.
	 * If the client property is not set, or not a color, defaultValue is returned.
	 */
	static Color clientPropertyColor( JComponent c, String key, Color defaultValue ) {
		return clientProperty( c, key, defaultValue, Color.class );
	}

	/**
	 * Returns the value of the specified client property if it is an instance of
	 * the specified type. Otherwise, defaultValue is returned.
	 *
	 * @since 2
	 */
	@SuppressWarnings( "unchecked" )
	static <T> T clientProperty( JComponent c, String key, T defaultValue, Class<T> type ) {
		Object value = c.getClientProperty( key );
		return type.isInstance( value ) ? (T) value : defaultValue;
	}
}
