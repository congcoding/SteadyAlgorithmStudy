class Solution {
    
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static int[] dc = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        // 초기화
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }
        
        // 회전
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = rotate(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }
        
        return answer;
    }
    
    public int rotate(int rs, int cs, int re, int ce) {
        int backup = map[rs][cs];
        int min = backup;
        int cr = rs;
        int cc = cs;
        for (int d = 0; d < 4; d++) {
            while (true) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr < rs || nr > re || nc < cs || nc > ce) {
                    break;
                }
                map[cr][cc] = map[nr][nc];
                min = Math.min(min, map[nr][nc]);
                cr = nr;
                cc = nc;
            }
        }
        map[rs][cs + 1] = backup;
        return min;
    }
}
