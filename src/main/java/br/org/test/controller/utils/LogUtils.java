package br.org.test.controller.utils;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;


public class LogUtils {

    private static final String ALERT_SUPPORT = "ALERT_SUPPORT";
    private static final Marker MARKER_ALERT_SUPPORT = MarkerFactory.getMarker(ALERT_SUPPORT);

    private LogUtils() {
    }

    public static Marker alertSupportMarker(){
        return MARKER_ALERT_SUPPORT;
    }
}
