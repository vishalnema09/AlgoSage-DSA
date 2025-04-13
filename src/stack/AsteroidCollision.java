package stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() < -a) {
                    st.pop();
                    continue;
                } else if (st.peek() == -a) {
                    st.pop();
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                st.push(a);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
