/*
1. discard all leading whitespace
2. sign of the number
3. overflow
4. invalid input
*/
int myAtoi(const char *str)
{
	int sign = 1, base = 0, i = 0;
	while(str[i] == ' ') i++;
	if(str[i] == '-' || str[i] == '+')
		sign = 1 - 2 * ((str[i++] == '-'));
	while(str[i] >= '0' && str[i] <= '9'){
		//-2147483648~2147483647 Because INT_MAX has been divided by 10, so the tail vanishes. if the tail is 8 or 9, it will overflow.
		if(base > INT_MAX / 10 || (sign == 1 && base == INT_MAX / 10 && str[i] > '7') || (sign == -1 && base == INT_MAX / 10 && str[i] > '8'))
		{
			if(sign == 1) return INT_MAX;
			else return INT_MIN;
		}
		base = 10 * base + (str[i++] - '0');
	}
	return base * sign;
}