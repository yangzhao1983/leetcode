package zy.basics.clazz;

/**
 * Created by kaiser_zhao on 2018/11/8.
 */
public class TestClone {
    public static final void main(String...strings){
        NoInterfaceClone nic = new NoInterfaceClone();
        InterfaceClone ic = new InterfaceClone();

        //NoInterfaceClone clonedNic = nic.getClonedInstance();
        InterfaceClone clonedIc = ic.getClonedInstance();
        System.out.println(clonedIc.equals(ic));
        System.out.println(clonedIc.getClass().toString());
    }
}

class NoInterfaceClone{

    private NoInterfaceClone nic = null;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public NoInterfaceClone getClonedInstance(){
        try {
            nic = (NoInterfaceClone)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return nic;
    }
}

class InterfaceClone implements Cloneable{

    private InterfaceClone ic = null;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public InterfaceClone getClonedInstance(){
        try {
            ic = (InterfaceClone)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return ic;
    }
}