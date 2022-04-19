# this program calculates the approximate grade level needed to comprehend a text using Coleman-Liau algorithm
import re


def main():
    text = input("Text: ")

    letters = getLetters(text)
    words = getWords(text)
    sentances = getSentance(text)

    # applying Coleman-Liau formula
    L = letters / words * 100
    S = sentances / words * 100
    index = round(0.0588 * L - 0.296 * S - 15.8)

    if index < 1:
        print("Before Grade 1")
    elif index >= 16:
        print("Grade 16+")
    else:
        print(f"Grade {index}")


def getLetters(text):
    counter = 0
    for letter in text:
        if letter.isalpha():
            counter += 1
    return counter


def getWords(text):
    return len(text.split())

# for this program, a sentance is considered any sequence of characters that ends with a ".", "!" or a "?" 
def getSentance(text):
    sentances = re.split(r"[.!?]", text)
    sentances = len(list(filter(None, result)))
    return sentances


main()
