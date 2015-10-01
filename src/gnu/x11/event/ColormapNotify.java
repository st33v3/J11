package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.ResponseInputStream;


/** X colormap notify event. */
public final class ColormapNotify extends Event {
  public static final int CODE = 32;


  public final int window_id;
  public final int colormap_id;
  public final boolean is_new;
  public final int state;

  public ColormapNotify (Display display, ResponseInputStream in) {
    super (display, in);
    window_id = in.read_int32 ();
    colormap_id = in.read_int32 ();
    is_new = in.read_bool ();
    state = in.read_int8 ();
    in.skip (18);
  }

@Override
public String toString() {
	return super.toString() + 
			"[window_id=" + window_id +
			", colormap_id=" + colormap_id +
			", is_new=" + is_new +
			", state=" + state +
			"]";
}

  
}
