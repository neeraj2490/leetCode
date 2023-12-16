/**
 * Find maximum sum of a subarray of size k.
 * 
 * Examples:
 * Input : arr[] = {100, 200, 300, 400}, k = 2
 * Output : 700
 * 
 * Input: arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output: 39
*/
#include <stdio.h>
#include <stdlib.h>

int main() {
    int size;
    int *arr;
    int maxSum = 0;
    int windowSize;

    printf("Enter the size of the array");
    scanf("%d", &size);

    printf("Enter the numbers");
    arr = (int*) malloc(size * sizeof(int));

    for(int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter the window size");
    scanf("%d", &windowSize);

    for(int i = 0; i < ( size - windowSize + 1); i++) { 
        int sum = 0;
        for(int j = 0; j < windowSize; j++) {
            sum += arr[i+j];
        }

        if(sum > maxSum) {
            maxSum = sum;
        }
    }

    printf("Max sum is %d \n", maxSum); 
}