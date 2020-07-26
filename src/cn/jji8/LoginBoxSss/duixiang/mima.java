package cn.jji8.LoginBoxSss.duixiang;

public class mima {

    int wuping[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int shuliang[] = {1,1,1,1,1,1,1,1,1};
    int zhizheng=0;
    String mimaT = null;

    public String toString() {
        StringBuffer t = new StringBuffer();
        for(int i =0;i<=8;i++){
            t.append(shuliang[i]);
        }
        for(int i =0;i<=8;i++){
            t.append(wuping[i]);
        }
        return t.toString();
    }
    //比较方法
    public boolean bijiao(){
        return toString().equals(mimaT);
    }
    //set方法
    public void setMimaT(String mimaT) {
        this.mimaT = mimaT;
    }
    //get方法
    public String getMimaT() {
        return mimaT;
    }
}
