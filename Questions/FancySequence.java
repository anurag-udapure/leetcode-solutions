class Fancy {

    long MOD = 1000000007;
    List<Long> raw = new ArrayList<>();
    long mult = 1, add = 0;

    long modinv(long x){
        long res = 1, p = MOD-2;
        while(p>0){
            if((p&1)==1) res=res*x%MOD;
            x=x*x%MOD;
            p>>=1;
        }
        return res;
    }

    public void append(int val){
        long base=(val-add)%MOD;
        base=base*modinv(mult)%MOD;
        raw.add((base+MOD)%MOD);
    }

    public void addAll(int inc){
        add=(add+inc)%MOD;
    }

    public void multAll(int m){
        mult=mult*m%MOD;
        add=add*m%MOD;
    }

    public int getIndex(int idx){
        if(idx>=raw.size()) return -1;
        return (int)((raw.get(idx)*mult+add)%MOD);
    }
}