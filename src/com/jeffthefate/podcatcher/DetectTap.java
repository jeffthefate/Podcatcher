package com.jeffthefate.podcatcher;

import android.util.Log;

public class DetectTap
{
    // Accelerometer data state
    public static enum PulseState {
        NonActive,
        PositivePulse,
        NegativePulse,
        UnknownPulse
    }

    // Threshold on x, y, z axes for identifying whether a tap triggers the   
    // accelerometer data change exceeds a threshold or not.  
    //private static float deltax_threshold = 8f;
    //private static float deltay_threshold = 8f;
    private float deltaz_threshold = 8f;

    // Declare the average x, y, z accelerometer data when device is static. 
    //public float x_initial;
    //public float y_initial;
    public float z_initial;

    // Declare the number of samples to calibrate the x_initial, y_intial,
    // z_initial. 
    //public int samplecounter_calibrate;
    // Declare the minimum number of samples required for calibration. 
    //private static final int MIN_CALIBRATE_INTERVAL = 10;
    // Declare the previous state, current state of x axis accelerometer data. 
    //private static PulseState PreviousState_X = PulseState.NonActive;
    //private static PulseState CurrentState_X = PulseState.NonActive;
    //private static PulseState PreviousState_Y = PulseState.NonActive;
    //private static PulseState CurrentState_Y = PulseState.NonActive;
    private static PulseState PreviousState_Z = PulseState.NonActive;
    private static PulseState CurrentState_Z = PulseState.NonActive;

    // Initialization
    public DetectTap() {
        //samplecounter_calibrate = 0;
    }
    
    public void setThreshold(float newThreshold) {
        Log.v(Constants.LOG_TAG, "setting deltaz_threshold: " + newThreshold);
        deltaz_threshold = newThreshold;
    }

    // Accelerometer calibration for the NonActive state. 
    /*
    public boolean calibrateInitialReading(float x, float y, float z) {
        // Initialize the variables. 
        if (samplecounter_calibrate == 0) {
            x_initial = 0;
            y_initial = 0;
            z_initial = 0;
        }

        // Increment the sample number of calibration. 
        samplecounter_calibrate++;

        // Skip the first 5 samples and then average the rest samplings of           
        // accelerometer data. The skipping is to skip the accelerometer data 
        // change due to the button press for calibration.  
        if (samplecounter_calibrate > 5 
                && samplecounter_calibrate <= MIN_CALIBRATE_INTERVAL) {
            x_initial = (x_initial * (samplecounter_calibrate - 6) + x) /  
            (samplecounter_calibrate - 5);
            y_initial = (y_initial * (samplecounter_calibrate - 6) + y) / 
            (samplecounter_calibrate - 5);
            z_initial = (z_initial * (samplecounter_calibrate - 6) + z) / 
            (samplecounter_calibrate - 5);
        }

        if (samplecounter_calibrate >= MIN_CALIBRATE_INTERVAL) {
            Log.d(Constants.LOG_TAG, "x_initial: " + x_initial);
            Log.d(Constants.LOG_TAG, "y_initial: " + y_initial);
            Log.d(Constants.LOG_TAG, "z_initial: " + z_initial);
            return true;
        }
        else
            return false;
    }
    */

    // State machine to detect the pulse on x axis accelerometer data. 
    /*
    public PulseState detectXPulse(float x)
    {
        float deltax = x - x_initial;
        if (Math.abs(deltax) < deltax_threshold)
            CurrentState_X = PulseState.NonActive;
        else {
            Log.i(Constants.LOG_TAG, "deltax: " + Math.abs(deltax));
            if (Math.abs(deltax) > Math.abs(DeltaxPeak))
                DeltaxPeak = deltax;
            switch (PreviousState_X) {
            case PositivePulse:
                if (deltax > 0)
                    CurrentState_X = PulseState.PositivePulse;
                else
                    CurrentState_X = PulseState.NegativePulse;
                break;

            case NegativePulse:
                if (deltax > 0)
                    CurrentState_X = PulseState.PositivePulse;
                else
                    CurrentState_X = PulseState.NegativePulse;
                break;

            case NonActive:
                if (deltax > 0)
                    CurrentState_X = PulseState.PositivePulse;
                else
                    CurrentState_X = PulseState.NegativePulse;
                break;
            default:
                break;
            }
        }

        PreviousState_X = CurrentState_X;
        x_initial = x;

        return CurrentState_X;
    }
    
    // State machine to detect the pulse on x axis accelerometer data. 
    public PulseState detectYPulse(float y)
    {
        float deltay = y - y_initial;
        if (Math.abs(deltay) < deltay_threshold)
            CurrentState_Y = PulseState.NonActive;
        else {
            Log.i(Constants.LOG_TAG, "deltay: " + Math.abs(deltay));
            if (Math.abs(deltay) > Math.abs(DeltayPeak))
                DeltayPeak = deltay;

            switch (PreviousState_Y) {
            case PositivePulse:
                if (deltay > 0)
                    CurrentState_Y = PulseState.PositivePulse;
                else
                    CurrentState_Y = PulseState.NegativePulse;
                break;

            case NegativePulse:
                if (deltay > 0)
                    CurrentState_Y = PulseState.PositivePulse;
                else
                    CurrentState_Y = PulseState.NegativePulse;
                break;

            case NonActive:
                if (deltay > 0)
                    CurrentState_Y = PulseState.PositivePulse;
                else
                    CurrentState_Y = PulseState.NegativePulse;
                break;
            default:
                break;
            }
        }

        PreviousState_Y = CurrentState_Y;
        y_initial = y;

        return CurrentState_Y;
    }
    */
    // State machine to detect the pulse on x axis accelerometer data. 
    public PulseState detectZPulse(float z)
    {
        float deltaz = z - z_initial;
        if (Math.abs(deltaz) < deltaz_threshold)
            CurrentState_Z = PulseState.NonActive;
        else {
            Log.i(Constants.LOG_TAG, "z: " + z);
            Log.i(Constants.LOG_TAG, "z_initial: " + z_initial);
            Log.i(Constants.LOG_TAG, "deltaz: " + Math.abs(deltaz));
            switch (PreviousState_Z) {
            case PositivePulse:
                if (deltaz > 0)
                    CurrentState_Z = PulseState.PositivePulse;
                else
                    CurrentState_Z = PulseState.NegativePulse;
                break;

            case NegativePulse:
                if (deltaz > 0)
                    CurrentState_Z = PulseState.PositivePulse;
                else
                    CurrentState_Z = PulseState.NegativePulse;
                break;

            case NonActive:
                if (deltaz > 0)
                    CurrentState_Z = PulseState.PositivePulse;
                else
                    CurrentState_Z = PulseState.NegativePulse;
                break;
            default:
                break;
            }
        }

        PreviousState_Z = CurrentState_Z;
        z_initial = z;

        return CurrentState_Z;
    }
}