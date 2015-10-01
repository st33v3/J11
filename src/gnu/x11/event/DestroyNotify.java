package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.ResponseInputStream;


/** X destroy notify event. */
public final class DestroyNotify extends Event {
	
  public static final int CODE = 17;

  public final int event_window_id;
  public final int window_id;

  public DestroyNotify (Display display, ResponseInputStream in) {
    super (display, in);
    event_window_id = in.read_int32 ();
    window_id = in.read_int32 ();
    in.skip (20);
  }

@Override
public String toString() {
	return super.toString() + "[wid=" + window_id + ", event_wid=" + event_window_id + "]";
}

  
}
