package model;

import enums.Color;
import enums.PhoneModel;
import enums.SimCard;

public abstract class DefaultIphone {
  private Color color;
  private PhoneModel phoneModel;
  private SimCard simCard;
  private Boolean dualChip = true;


  //#region Constructor
  public DefaultIphone(Color color, PhoneModel phoneModel, SimCard simCard) {
    this.color = color;
    this.phoneModel = phoneModel;
    this.simCard = simCard;
  }
  //#endregion

  //#region Getters and setters 
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PhoneModel getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(PhoneModel phoneModel) {
        this.phoneModel = phoneModel;
    }

    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public void setDualChip(boolean dualChip) {
      this.dualChip = dualChip;
  }

    public boolean isDualChip() {
      return dualChip;
    }
  //#endregion


};
