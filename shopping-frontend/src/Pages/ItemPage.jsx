import React, { useEffect, useState } from 'react';

export default function ItemsPage() {
  const [items, setItems] = useState([]);

  const token = localStorage.getItem('token');

  useEffect(() => {
    fetch('http://localhost:8080/items')
      .then(res => res.json())
      .then(setItems);
  }, []);

  const addToCart = async (itemId) => {
    await fetch('http://localhost:8080/carts', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': token
      },
      body: JSON.stringify({ item_id: itemId })
    });
    alert("Item added to cart!");
  };

  const checkout = async () => {
    const res = await fetch('http://localhost:8080/orders', {
      method: 'POST',
      headers: { 'Authorization': token }
    });

    if (res.ok) alert("Order successful!");
  };

  const viewCart = async () => {
    const res = await fetch('http://localhost:8080/carts', {
      headers: { 'Authorization': token }
    });
    const data = await res.json();
    let message = data.find(c => c.user && c.user.token === token)?.items?.map(item => `Item ID: ${item.id}`).join('\n') || "No cart";
    alert(message);
  };

  const viewOrders = async () => {
    const res = await fetch('http://localhost:8080/orders', {
      headers: { 'Authorization': token }
    });
    const data = await res.json();
    let message = data.map(o => `Order ID: ${o.id}`).join('\n');
    alert(message);
  };

  return (
    <div>
      <button onClick={checkout}>Checkout</button>
      <button onClick={viewCart}>View Cart</button>
      <button onClick={viewOrders}>Order History</button>
      <h2>Items:</h2>
      <ul>
        {items.map(item => (
          <li key={item.id}>
            {item.name} - ₹{item.price}
            <button onClick={() => addToCart(item.id)}>Add to Cart</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
