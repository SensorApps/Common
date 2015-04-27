package org.sensors2.common.sensors;

import android.hardware.Sensor;

/**
 * Created by thomas on 05.11.14.
 */
public abstract class Parameters {
    private final int sensorType;
    private final int dimensions;
    private final String sensorName;
    private final float range;
    private final float resolution;


    public Parameters(Sensor sensor) {
        this.sensorType = sensor.getType();
        this.sensorName = sensor.getName();
        this.range = sensor.getMaximumRange();
        this.resolution = sensor.getResolution();
        switch (sensorType) {
            // 1 int TYPE_ACCELEROMETER A constant describing an accelerometer sensor type.
            case 1:
                this.dimensions = 3;
                break;
            // 2 int TYPE_MAGNETIC_FIELD A constant describing a magnetic field sensor type.
            case 2:
                this.dimensions = 3;
                break;
            // 3 int TYPE_ORIENTATION This constant was deprecated in API level 8. use SensorManager.getOrientation() instead.
            case 3:
                this.dimensions = 3;
                break;
            // 4 int TYPE_GYROSCOPE A constant describing a gyroscope sensor type
            case 4:
                this.dimensions = 3;
                break;
            // 5 int TYPE_LIGHT A constant describing a light sensor type.
            case 5:
                this.dimensions = 1;
                break;
            // 6 int TYPE_PRESSURE A constant describing a pressure sensor type
            case 6:
                this.dimensions = 1;
                break;
            // 7 int TYPE_TEMPERATURE This constant was deprecated in API level 14. use Sensor.TYPE_AMBIENT_TEMPERATURE instead.
            case 7:
                this.dimensions = 1;
                break;
            // 8 int TYPE_PROXIMITY A constant describing a proximity sensor type.
            case 8:
                this.dimensions = 1;
                break;
            // 9 int TYPE_GRAVITY A constant describing a gravity sensor type.
            case 9:
                this.dimensions = 3;
                break;
            // 10 int TYPE_LINEAR_ACCELERATION A constant describing a linear acceleration sensor type.
            case 10:
                this.dimensions = 3;
                break;
            // 11 int TYPE_ROTATION_VECTOR A constant describing a rotation vector sensor type.
            case 11:
                this.dimensions = 4;
                break;
            // 12 int TYPE_RELATIVE_HUMIDITY A constant describing a relative humidity sensor type.
            case 12:
                this.dimensions = 1;
                break;
            // 13 int TYPE_AMBIENT_TEMPERATURE A constant describing an ambient temperature sensor type
            case 13:
                this.dimensions = 1;
                break;
            // 14 int TYPE_MAGNETIC_FIELD_UNCALIBRATED A constant describing an uncalibrated magnetic field sensor type.
            case 14:
                this.dimensions = 6;
                break;
            // 15 int TYPE_GAME_ROTATION_VECTOR A constant describing an uncalibrated rotation vector sensor type.
            case 15:
                this.dimensions = 3;
                break;
            // 16 int TYPE_GYROSCOPE_UNCALIBRATED A constant describing an uncalibrated gyroscope sensor type.
            case 16:
                this.dimensions = 6;
                break;
            // TYPE_SIGNIFICANT_MOTION A constant describing a significant motion trigger sensor.
            case 17:
                this.dimensions = 1;
                break;
            // TYPE_STEP_COUNTER A constant describing a step detector sensor.
            case 18:
                this.dimensions = 1;
                break;
            // TYPE_STEP_DETECTOR A constant describing a step detector sensor.
            case 19:
                this.dimensions = 1;
                break;
            // TYPE_GEOMAGNETIC_ROTATION_VECTOR A constant describing a geo-magnetic rotation vector.
            case 20:
                this.dimensions = 4;
                break;
            // TYPE_HEART_RATE A constant describing a heart rate monitor.
            case 21:
                this.dimensions = 1;
                break;
            // TYPE_TILT_DETECTOR
            case 22:
                this.dimensions = 1;
                break;
            // TYPE_WAKE_GESTURE
            case 23:
                this.dimensions = 1;
                break;
            // TYPE_GLANCE_GESTURE
            case 24:
                this.dimensions = 1;
                break;
            // TYPE_PICK_UP_GESTURE
            case 25:
                this.dimensions = 1;
                break;

            default:
                this.dimensions = 6; // the maximum
                break;
            //throw new IllegalArgumentException();
        }
    }

    public int getSensorType() {
        return this.sensorType;
    }

    public int getDimensions() {
        return this.dimensions;
    }

    public float getResolution() {
        return this.resolution;
    }

    public float getRange() {
        return this.range;
    }

    public String getSensorName() {
        return this.sensorName;
    }
}
