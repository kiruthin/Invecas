# Invecas
This repository contains two classes for the requested coding exercises:

## StringCounter 

This class utilitizes HashMap maintain a list of key value pairs. The input string is used as the key and the cummulitive counter is used and the value. In general put and get functions for HashMaps are O(1). The put function has been overriden to include an lookup for existing keys and a store of the cumulative counter of any exisiting keys found. 

## PaliTest

This class tests whether a string is a palindrome. A palindrome is a word or phrase that is spelled exactly the same forwards or backwards. In our case we ignore non-alphanumeric characters and consider lower and upper case characters to be identical. For this solution we iterate through the individual characters of the string and check for any inconsistencies. On a worst case this should be O(n/2).

