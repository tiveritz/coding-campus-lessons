package src.com.dcv.jan.day46.interfaces;

import src.com.dcv.jan.day46.models.ArtPiece;

public interface IVisitor {
    void observeArtPiece(ArtPiece artPiece);
    void leaveMuseum();
}