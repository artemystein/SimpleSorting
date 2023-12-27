//  SelectSorting.java

package sortintgexample;

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class SelectSorting {

    public enum MonoOperatorModes {
        bubble, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs, ln,
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.bubble) {
            return num * num;
        }

        // never reach
        throw new Error();
    }

}
