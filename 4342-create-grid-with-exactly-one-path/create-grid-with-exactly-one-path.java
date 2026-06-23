class Solution {
    public String[] createGrid(int bhatura, int chole) {
        String[] dabba = new String[bhatura];
        StringBuilder pehlaRasta = new StringBuilder();
        
        for (int chintu = 0; chintu < chole; chintu++) {
            pehlaRasta.append(".");
        }
        dabba[0] = pehlaRasta.toString();
        
        if (bhatura > 1) {
            StringBuilder bakiRasta = new StringBuilder();
            for (int pintu = 0; pintu < chole - 1; pintu++) {
                bakiRasta.append("#");
            }
            bakiRasta.append(".");
            String deewar = bakiRasta.toString();
            
            for (int montu = 1; montu < bhatura; montu++) {
                dabba[montu] = deewar;
            }
        }
        
        return dabba;
    }
}