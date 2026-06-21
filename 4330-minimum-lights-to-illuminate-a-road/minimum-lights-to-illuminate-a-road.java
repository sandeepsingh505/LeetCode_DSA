class Solution {
    public int minLights(int[] tubelight) {
        int rasta = tubelight.length;
        int[] jadoo = new int[rasta + 1];
        
        for (int chintu = 0; chintu < rasta; chintu++) {
            int roshni = tubelight[chintu];
            if (roshni > 0) {
                int piche = Math.max(0, chintu - roshni);
                int aage = Math.min(rasta - 1, chintu + roshni);
                jadoo[piche]++;
                jadoo[aage + 1]--;
            }
        }
        
        int ujala = 0;
        boolean[] chamak = new boolean[rasta];
        
        for (int i = 0; i < rasta; i++) {
            ujala += jadoo[i];
            if (ujala > 0) {
                chamak[i] = true;
            }
        }
        
        int nayaBulb = 0;
        int kadam = 0;
        
        while (kadam < rasta) {
            if (!chamak[kadam]) {
                nayaBulb++;
                kadam += 3;
            } else {
                kadam++;
            }
        }
        
        return nayaBulb;
    }
}