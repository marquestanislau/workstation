<div class="productos view">
<h2><?php echo __('Producto'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['nome']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Sku'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['sku']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Quantidade'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['quantidade']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Descricao'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['descricao']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Foto'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['foto']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Referencia'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['referencia']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Preco Aquisicao'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['preco_aquisicao']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Data De Registo'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['data_de_registo']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Estoque Minimo'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['estoque_minimo']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Data De Validade'); ?></dt>
		<dd>
			<?php echo h($producto['Producto']['data_de_validade']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Producto'), array('action' => 'edit', $producto['Producto']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Producto'), array('action' => 'delete', $producto['Producto']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $producto['Producto']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Productos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Producto'), array('action' => 'add')); ?> </li>
	</ul>
</div>
