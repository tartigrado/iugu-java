package com.iugu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class Contest {

    @JsonProperty("file_1")
    private File file1;
    @JsonProperty("file_2")
    private File file2;
    @JsonProperty("file_3")
    private File file3;
    @JsonProperty("file_4")
    private File file4;
    @JsonProperty("file_5")
    private File file5;

    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public File getFile3() {
        return file3;
    }

    public void setFile3(File file3) {
        this.file3 = file3;
    }

    public File getFile4() {
        return file4;
    }

    public void setFile4(File file4) {
        this.file4 = file4;
    }

    public File getFile5() {
        return file5;
    }

    public void setFile5(File file5) {
        this.file5 = file5;
    }

}
