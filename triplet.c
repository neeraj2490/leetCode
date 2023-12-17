/**
 * Given an array of distinct elements. 
 * The task is to find triplets in the array whose sum is zero.
 * Examples:
 * Input : arr[] = {0, -1, 2, -3, 1}
 * Ouput : (0, -1, 1), (2, -3, 1)
*/

#include <stdio.h>
#include <stdlib.h>

int cmpFunction(const void *a,  const void *b) {
    return ( *(int*)a - *(int*)b );
}

int main() {
    int size;
    int *arr;
    
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    arr = malloc(size * sizeof(int));

    printf("Enter the elements of the array: ");

    for(int i = 0; i < size; i++) { 
        scanf("%d", &arr[i]);
    };

    qsort(arr, 5, sizeof(int), cmpFunction);

    for(int i = 0; i < (size - 2); i++) {
        int j = i + 1;
        int k = size - 1;
        while(j < k) {
            int sum = arr[i] + arr[j] + arr[k];
            if(sum == 0) {
                printf("(%d, %d, %d)\n", arr[i], arr[j], arr[k]);
                j = k;
            } else if(sum < 0) {
                j++;
            } else {
                k --;
            }
        }
    }
}