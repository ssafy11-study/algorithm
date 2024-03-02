#include <cstdio>
int min(int a, int b) { return a < b ? a : b; }
int goal, start;
int g(int sub_goal) {
    if (sub_goal < start) return start - sub_goal;
	if (sub_goal == start) return 0;
	if (sub_goal == 1) return 1;
	
	if (sub_goal % 2 == 0) return min(sub_goal - start, g(sub_goal / 2));
	else return 1 + min(g(sub_goal + 1), g(sub_goal - 1));
}
int main() {
	scanf("%d%d", &start, &goal);
	printf("%d", g(goal));
	return 0;
}