package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.ResponseInputStream;


/** X create notify event. */
public final class CreateNotify extends Event {
  
	public static final int CODE = 16;


  public final int parent_id;
  public final int window_id;
  public final int x;
  public final int y;
  public final int width;
  public final int height;
  public final int border_width;
  public final boolean override_redirect;

  public CreateNotify (Display display, ResponseInputStream in) {
    super (display, in); 
    parent_id = in.read_int32 ();
    window_id = in.read_int32 ();
    x = in.read_int16 ();
    y = in.read_int16 ();
    width = in.read_int16 ();
    height = in.read_int16 ();
    border_width = in.read_int16 ();
    override_redirect = in.read_bool ();
    in.skip (9);
  }

@Override
public String toString() {
	return super.toString() + 
			"[parent_id=" + parent_id +
			", window_id=" + window_id +
			", x=" + x +
			", y=" + y +
			", width=" + width +
			", height=" + height +
			", border_width=" + border_width +
			", override_redirect=" + override_redirect +
			"]";
}

  
}
