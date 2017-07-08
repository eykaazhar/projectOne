/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ASUS
 */
public class BusinessException extends Exception {

    public BusinessException() {
    }
    
    public BusinessException(String msg) {
        super(msg);
    }
    
    public BusinessException(String msg, Throwable T) {
        super(msg, T);
    }
}
