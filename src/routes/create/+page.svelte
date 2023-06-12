<script>
    import Nav from "../nav/nav.svelte";

    let productName = "";
    let pricePerHour = "";
    let availableFromDate = "";
    let availableToDate = "";

    async function createProduct() {
        const response = await fetch("/api/products", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                productName,
                pricePerHour,
                availableFromDate,
                availableToDate,
            }),
        });
        // Handle the response
    }
</script>

<Nav />
<!-- <form on:submit|preventDefault={createProduct}>
    <label for="productName">Product Name</label>
    <input type="text" id="productName" bind:value={productName} />

    <label for="pricePerHour">Price per Hour</label>
    <input type="number" id="pricePerHour" bind:value={pricePerHour} />

    <label for="availableFromDate">Available From Date</label>
    <input type="date" id="availableFromDate" bind:value={availableFromDate} />

    <label for="availableToDate">Available To Date</label>
    <input type="date" id="availableToDate" bind:value={availableToDate} />

    <button type="submit">Create</button>
</form> -->

<form on:submit|preventDefault={createProduct}>
    <div class="grid gap-6 mb-6 md:grid-cols-2">
        <div>
            <label
                for="productName"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-black"
                >Product Name</label
            >
            <input
                type="text"
                id="productName"
                bind:value={productName}
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="cycle"
                required
            />
        </div>
        <div>
            <label
                for="pricePerHour"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-black"
                >Price per Hour</label
            >
            <input
                type="text"
                id="pricePerHour"
                bind:value={pricePerHour}
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="25"
                required
            />
        </div>
        <div>
            <label
                for="availableFromDate"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-black"
                >Available From Date</label
            >
            <input
                type="datetime-local"
                id="availableFromDate"
                bind:value={availableFromDate}
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="Flowbite"
                required
            />
        </div>
        <div>
            <label
                for="availableToDate"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-black"
                >Available To Date</label
            >
            <input
                type="datetime-local"
                id="availableToDate"
                bind:value={availableToDate}
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="123-45-678"
                pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
                required
            />
        </div>
    </div>
    <button
        type="submit"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
        >Submit</button
    >
</form>
<style>
    form{
        margin-top: 90px;
    }
</style>