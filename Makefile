
MAIN := Main
SRCS := Main.java Game.java Board.java GamePiece.java Player.java HumanPlayer.java AIPlayer.java Board.java
CLASSES = $(SRCS:.java=.class)
JFLAGS = -g -Xlint:unchecked

# The targets following .PHONY aren't actually files; they serve as commands.
.PHONY: compile default clean

compile: $(CLASSES)

default: compile

clean:
	$(RM) *.class *~ *.*.png

$(CLASSES): $(SRCS)
	javac $(JFLAGS) $(SRCS)

run: compile
	java $(MAIN)