package th.co.progaming.playbento;

import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;

import java.util.List;

/**
 * Created by Chatpong on 11/3/2015 AD.
 */
public class DeviceCamera {
    public void enableAutofocus() {
        Camera camera = Camera.open();
        Camera.Parameters parameters = camera.getParameters();
        List<String> focusModes = parameters.getSupportedFocusModes();
        if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        }
        camera.setParameters(parameters);
    }
}