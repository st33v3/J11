package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.Rectangle;
import gnu.x11.ResponseInputStream;


/** X configure notify event. */
public final class ConfigureNotify extends Event {
  public static final int CODE = 22;

  public final int event_window_id;
  public final int window_id;
  public final int above_sibling_id;

  public final int x;
  public final int y;
  public final int width;
  public final int height;

  public final int border_width;
  public final boolean override_redirect;

  /** Reading. */
  public ConfigureNotify (Display display, ResponseInputStream in) {
    super (display, in);
    event_window_id = in.read_int32 ();
    window_id = in.read_int32 ();
    above_sibling_id = in.read_int32 ();
    x = in.read_int16 ();
    y = in.read_int16 ();
    width = in.read_int16 ();
    height = in.read_int16 ();
    border_width = in.read_int16 ();
    override_redirect = in.read_bool();
    in.skip (5);
  }


  //-- reading

  public int event_id () {
    return event_window_id;
  }

  public int above_sibling_id () {
    return above_sibling_id;
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

  public Rectangle rectangle () {
    return new Rectangle (x (), y (), width (), height ());
  }


@Override
public String toString() {
	return super.toString() + 
			"[event_window_id=" + event_window_id +
			", window_id=" + window_id +
			", above_sibling_id=" + above_sibling_id +
			", x=" + x +
			", y=" + y +
			", width=" + width +
			", height=" + height +
			", border_width=" + border_width +
			", override_redirect=" + override_redirect +
			"]";
}

  
}
