package iit.csp595;

public enum Actions {
  INVALID(-1),
  ADD_TO_CART(1),
  REMOVE_FROM_CART(2),
  INCREASE_COUNT(3),
  DECREASE_COUNT(4),
  LOGIN(5),
  LOGOUT(6),
  CANCEL_ORDER(7),
  SUBMIT_ORDER(8),
  CONFIRM_ORDER(9),
  MODIFY_ACCOUNT(10),
  DELETE_ACCOUNT(11),
  CLEAR_CART(12),
  SAVE_ACCOUNT(13),
  VIEW_ORDER(14),
  NEW_ACCOUNT(15);

  private final int id;

  private Actions(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public static Actions getAction(int id) {
    switch (id) {
    case -1:
      return INVALID;
    case 1:
      return ADD_TO_CART;
    case 2:
      return REMOVE_FROM_CART;
    case 3:
      return INCREASE_COUNT;
    case 4:
      return DECREASE_COUNT;
    case 5:
      return LOGIN;
    case 6:
      return LOGOUT;
    case 7:
      return CANCEL_ORDER;
    case 8:
      return SUBMIT_ORDER;
    case 9:
      return CONFIRM_ORDER;
    case 10:
      return MODIFY_ACCOUNT;
    case 11:
      return DELETE_ACCOUNT;
    case 12:
      return CLEAR_CART;
    case 13:
      return SAVE_ACCOUNT;
    case 14:
      return VIEW_ORDER;
    case 15:
      return NEW_ACCOUNT;
    default:
      return INVALID;
    }

  }

}
