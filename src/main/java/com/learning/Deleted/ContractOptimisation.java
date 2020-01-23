package com.learning.Deleted;

import com.learning.Java8NewFeature.LambdaExpression.Lambda3.Student;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.logging.Logger;

class ClassNotMatchedException extends RuntimeException{

    ClassNotMatchedException(String message){
        super(message);
    }

}

class Contract{

    private Long contractId;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    Contract(Long contractId){
        this.contractId=contractId;
    }

    Contract(){super();};

}


public class ContractOptimisation<E> implements Serializable,Cloneable, RandomAccess {

    static{
       contract = new Contract();
    }

    private Logger logger = Logger.getLogger("ContractOptimisation");

    private static Contract contract;

    public ContractOptimisation() throws ClassNotFoundException {
    }


    @Test(dataProvider = "ContractProvider")
    public void contractOptimised(Object merchantId){

        if(merchantId instanceof Contract && contract!=null){
          contract =  new Contract(new Long(2122));
        }else{
            throw new ClassNotMatchedException("\n"+"Actual :"+merchantId.getClass().getName()+"\n"+"Expected :"+contract.getClass().getName());
           // Assert.assertEquals(merchantId.getClass().getName(),new Contract().getClass().getName());
        }

        logger.info(contract.getContractId().toString());

    }

    @DataProvider(name="ContractProvider")
    public Object[] contractData(){
        return new Object[]{new Contract(),new String("12321"),new Student(1,"Demo")};
    }

}
