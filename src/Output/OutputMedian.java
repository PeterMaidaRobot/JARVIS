package Output;

public class OutputMedian {

    private boolean textOutput = false;
    private boolean smsOutput = false;
    private boolean verbalOutput = false;

    public OutputMedian() {
    }

    public void turnOnTextOutput() {
        this.textOutput = true;
    }

    public boolean isTextOutput() {
        return textOutput;
    }

    public void turnOnSmsOutput() {
        this.smsOutput = true;
    }

    public boolean isSmsOutput() {
        return smsOutput;
    }

    public void turnOnVerbalOutput() {
        this.verbalOutput = true;
    }

    public boolean isVerbalOutput() {
        return verbalOutput;
    }
}
