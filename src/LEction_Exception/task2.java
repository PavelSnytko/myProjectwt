package LEction_Exception;

import org.apache.log4j.Logger;
/**
 * 2.Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.
 */

public class task2 {
    private static Logger LOGGER = Logger.getLogger(task2.class); //вызываел логгер
    public static void main(String[] args) {

            int array[] = new int[7];
            try {
                for (int i = 0; ; i++) {
                    if (i == (array.length + 1)) {
                        throw new Exception("ArrayIndexOutOfBoundsException");
                    }
                    array[i] = i;
                }


            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.info("Exception handling---");
                LOGGER.error(e);
                LOGGER.info("Ending exception handling---");
                System.out.println(e.getMessage());

            }
        }
    }


