/**
 * Bisection.java
 * The code implements Bisection method
 * @author Sevval MEHDER 151044009
 */
public class Bisection {

    public static void main(String args[] ){

        bisectionMethod( Double.parseDouble( args[0] ) ,
                         Double.parseDouble( args[1] ) ,
                         args[2],
                         Double.parseDouble( args[3] ) );

    }

    /**
     * This function implement Bisection method.
     * @param start_a the start of the root search interval as a real value
     * @param finish_b the end of the root search interval as a real value
     * @param stoppingCriterion  the type of stopping criterion as a String
     * @param epsilon ϵ as a real value
     * @return boolean, if we find a root before 100 iterations return true, otherwise false
     */
    public static boolean bisectionMethod( double start_a, double finish_b, String stoppingCriterion, double epsilon){

        int curIterVal = 1; //Current iteration value
        double root, rootNext;
        double a = start_a, b = finish_b;

        root = (start_a + finish_b) / 2 ; //Find root

        System.out.println("Iteration: " + curIterVal
                         + "\tthe absolute error: " + String.format("%.10f", calculateAbsoluteError(start_a, root))
                         + "\tthe relative error: " + String.format("%.10f", calculateRelativeError(start_a ,root)));


        do{
            if( F(start_a) * F(root) < 0 ) //If they have opposite signs
                b = root;
            else
                a = root;

            rootNext = (a + b) / 2;  //Change root

            //Before 100 iteration, search the given stopping criterion
            if( ErrorChecks(stoppingCriterion, root, rootNext, epsilon) ){
                ++curIterVal;
                System.out.println("Iteration: " + curIterVal
                        + "\tthe absolute error: " + String.format("%.10f", calculateAbsoluteError(root,rootNext))
                        + "\tthe relative error: " + String.format("%.10f", calculateRelativeError(root,rootNext)) );
                System.out.println("After " + curIterVal + " iterations," + " approximate root is found " + rootNext
                        + "\nTheoretically required " + curIterVal + " iterations");
                return true;
            }
            ++curIterVal; //Increase the iteration

            System.out.println("Iteration: " + curIterVal
                    + "\tthe absolute error: " + String.format("%.10f", calculateAbsoluteError(root,rootNext))
                    + "\tthe relative error: " + String.format("%.10f", calculateRelativeError(root,rootNext)) );

            root = rootNext;

        }
        while(curIterVal <= 100);
        //After 100 iteration give an error message
        System.out.printf("There is no root on this ");

        return false;
    }

    /**
     * This is our test function.
     * Change function F for your problem.
     * @param targetValue the value of will be calculated
     * @return the result of ewuation for the given value
     */
    private static double F(double targetValue)
    {
        double f;

        /*System.out.println("a) 3x − e^x = 0 for 1 ≤ x ≤ 2");
        f = (3 * targetValue ) - Math.exp(targetValue);*/

       /* System.out.println("b) 2x + 3cos x − e^x = 0 for 0 ≤ x ≤ 1");
        f = 2*targetValue + 3*Math.cos(targetValue) - Math.exp(targetValue);*/

        /*System.out.println("c) x^2 − 4x + 4 − lnx = 0 for 1 ≤ x ≤ 2");
        f = (targetValue*targetValue - 4*targetValue + 4 - Math.log(targetValue));*/

        /*System.out.println("c) x^2 − 4x + 4 − lnx = 0 for 2 ≤ x ≤ 4");
        f = (targetValue*targetValue - 4*targetValue + 4 - Math.log(targetValue));*/

        /*System.out.println("d) x + 1 − 2sin(πx) = 0 for 0 ≤ x ≤ 0.5");
        f = (targetValue + 1 - (2*Math.sin(targetValue*Math.PI)));*/

        /*System.out.println("d) x + 1 − 2sin(πx) = 0 for 0.5 ≤ x ≤ 1");*/
        f = (targetValue + 1 - (2*Math.sin(targetValue*Math.PI)));


        return f;

    }

    /**
     *
     * @param errorType type of error
     * @param rootF first root (P(n-1))
     * @param rootS second root(P(n))
     * @param epsilonValue the epsilon value
     * @return if there is given error it return false, otherwise true
     */
    private static boolean ErrorChecks( String errorType, double rootF, double rootS, double epsilonValue ){

        if( errorType.equalsIgnoreCase( "DISTANCE_TO_ROOT" )){

            if( Math.abs( F(rootS) ) < epsilonValue )
                return true;
            else
                return false;
        }
        else if( errorType.equalsIgnoreCase( "ABSOLUTE_ERROR" )){

            if( Math.abs( rootS - rootF ) < epsilonValue )
                return true;
            else
                return false;

        }
        else if( errorType.equalsIgnoreCase( "RELATIVE_ERROR" )){

            if(Math.abs(rootS - rootF) / Math.abs(rootS) < epsilonValue)
                return true;
            else
                return false;

        }
        else
            return false;
    }

    /**
     *
     * @param root first root (P(n-1))
     * @param rootNext second root(P(n))
     * @return the value of absolute errors
     */
    public static double calculateAbsoluteError(double root, double rootNext){
        return Math.abs( rootNext - root );
    }

    /**
     *
     * @param root first root (P(n-1))
     * @param rootNext second root(P(n))
     * @return the value of relative errors
     */
    public static double calculateRelativeError(double root, double rootNext){
        return Math.abs(rootNext - root) / Math.abs(rootNext);
    }


}
