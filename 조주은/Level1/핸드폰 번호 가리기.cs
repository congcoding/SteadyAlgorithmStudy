public class Solution {
    public string solution(string phone_number) {
        
        if(phone_number.Length >= 4 )
        {
            if(phone_number.Length - 4 > 0)
            {
                for(var i=0; i< phone_number.Length - 4; i++)
                {
                    phone_number = phone_number.Replace(phone_number[i], '*');
                }
            }
        }
        
        
        return phone_number+"";
    }
}
