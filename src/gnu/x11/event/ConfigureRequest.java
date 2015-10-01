package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.Rectangle;
import gnu.x11.ResponseInputStream;
import gnu.x11.Window;


/** X configure request event. */
public final class ConfigureRequest extends Event {
  public static final int CODE = 23;

  public final int parent_window_id;
  public final int window_id;
  public final int sibling_id;

  public final int x;
  public final int y;
  public final int width;
  public final int height;

  public final int border_width;
  public final int value_mask;


  public ConfigureRequest (Display display, ResponseInputStream in) {
    super (display, in);
    parent_window_id = in.read_int32 ();
    window_id = in.read_int32 ();
    sibling_id = in.read_int32 ();
    x = in.read_int16 ();
    y = in.read_int16 ();
    width = in.read_int16 ();
    height = in.read_int16 ();
    border_width = in.read_int16 ();
    value_mask = in.read_int16 ();
    in.skip (4);
  }


  public Window.Changes changes () {
    Window.Changes c = new Window.Changes ();

    c.stack_mode (stack_mode ());
    c.sibling_id (sibling_id ());
    c.x (x ());
    c.y (y ());
    c.width (width ());
    c.height (height ());
    c.border_width (border_width ());

    // since above function calls will change bitmask, 
    // read bitmask last
    c.bitmask = bitmask ();
    return c;
  }


  public int stack_mode () {
    return detail;
  }

  public int sibling_id () {
    return sibling_id;
  }

  public int x () {
    return x;
  }

  public int y () {
    return y;
  }

  public int width () {
    return width;
  }

  public int height () {
    return height;
  }

  public int border_width () {
    return border_width;
  }

  public int bitmask () {
    return value_mask;
  }

  public Rectangle rectangle () {
    return new Rectangle (x (), y (), width (), height ());
  }


  @Override
  public String toString() {
    return super.toString() + 
	  "[parent_window_id=" + parent_window_id +
      ", window_id=" + window_id +
	  ", sibling_id="	+ sibling_id +
	  ", x=" + x +
	  ", y=" + y +
	  ", width=" + width +
	  ", height=" + height +
	  ", border_width=" + border_width +
	  ", value_mask=" + value_mask +
	  "]";
 }
  
  
}
