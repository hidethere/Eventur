export interface IOrder {
    createdAt: Date
    stripeId: string
    totalAmount: string
    event: {
      _id: string
      title: string
    }
    buyer: {
      _id: string
      firstName: string
      lastName: string
    }
  }
  
  export type IOrderItem = {
    _id: string
    totalAmount: string
    createdAt: Date
    eventTitle: string
    eventId: string
    buyer: string
  }