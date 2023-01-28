class Solution {
    public String intToRoman(int num) {
        String return_val = "";
        
        while(num >= 1000) {
            return_val += "M";
            num -= 1000;
        }
        
        switch(num / 100) {
            case 1:
                return_val += "C";
                break;
            case 2:
                return_val += "CC";
                break;
            case 3:
                return_val += "CCC";
                break;
            case 4:
                return_val += "CD";
                break;
            case 5:
                return_val += "D";
                break;
            case 6:
                return_val += "DC";
                break;
            case 7:
                return_val += "DCC";
                break;
            case 8:
                return_val += "DCCC";
                break;
            case 9:
                return_val += "CM";
                break;
            default:
                return_val += "";
                break;
        } 

        num = num % 100;
        
        switch(num / 10) {
              case 1:
                return_val += "X";
                break;
            case 2:
                return_val += "XX";
                break;
            case 3:
                return_val += "XXX";
                break;
            case 4:
                return_val += "XL";
                break;
            case 5:
                return_val += "L";
                break;
            case 6:
                return_val += "LX";
                break;
            case 7:
                return_val += "LXX";
                break;
            case 8:
                return_val += "LXXX";
                break;
            case 9:
                return_val += "XC";
                break;
            default:
                return_val += "";
                break;
        } 
        
        num = num % 10;
        
        switch(num) {
              case 1:
                return_val += "I";
                break;
            case 2:
                return_val += "II";
                break;
            case 3:
                return_val += "III";
                break;
            case 4:
                return_val += "IV";
                break;
            case 5:
                return_val += "V";
                break;
            case 6:
                return_val += "VI";
                break;
            case 7:
                return_val += "VII";
                break;
            case 8:
                return_val += "VIII";
                break;
            case 9:
                return_val += "IX";
                break;
            default:
                return_val += "";
                break;
        } 
        
        return return_val;
    }
}