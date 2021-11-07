using System;

public class Solution {
    public int solution(string skill, string[] skill_trees) {
        int return_value = skill_trees.Length;
        int beforeIdx = 0;
        int currentIdx = 0;

        for (int i = 0; i < skill_trees.Length; i++)
        {
            beforeIdx = skill_trees[i].IndexOf(skill[0]);
            
            for ( int j=1;j<skill.Length;j++)
            {
                currentIdx = skill_trees[i].IndexOf(skill[j]);
                                                         
                if((currentIdx<beforeIdx && currentIdx!=-1)||(currentIdx!=-1&&beforeIdx==-1))
                {
                    return_value--;
                    break;
                }
                
                beforeIdx = currentIdx;
            }
        }
                                                         
        return return_value;
    }
}
