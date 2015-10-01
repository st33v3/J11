package gnu.x11.event;

import gnu.x11.Display;
import gnu.x11.ResponseInputStream;


/** X map notify event. */
public final class MapNotify extends Event {
  
	public static final int CODE = 19;

  public final int event_window_id;
  public final int window_id;
  public final boolean override_redirect;

  public MapNotify (Display display, ResponseInputStream in) {
    super (display, in);
    event_window_id = in.read_int32 ();
    window_id = in.read_int32 ();
    override_redirect = in.read_bool ();
    in.skip (19);
  }

@Override
public String toString() {
	return super.toString() + 
			"[event_window_id=" + event_window_id +
			", window_id=" + window_id +
			", override_redirect=" + override_redirect +
			"]";
}
  
  
}
